package tn.esprit.infenion.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import tn.esprit.infenion.Entities.Preference;
import tn.esprit.infenion.Entities.User;
import tn.esprit.infenion.Entities.Voyage;
import tn.esprit.infenion.IService.IPreferenceService;
import tn.esprit.infenion.IService.IUserService;
import tn.esprit.infenion.IService.IVoyageService;
import tn.esprit.infenion.Service.MapValidationErrorService;
import tn.esprit.infenion.Service.PreferenceService;
import tn.esprit.infenion.Validator.VoyageValidatore;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/voyage")
public class VoyageRestController {

	@Autowired
    IPreferenceService preferenceService;

    @Autowired
    IVoyageService VoyageService;
    
    
    
    @Autowired
    IUserService userService ;

    @Autowired
    VoyageValidatore voyageValidatore ;
    @Autowired
    MapValidationErrorService mapValidationErrorService ;

    @GetMapping("/retrieve-all-Voyage")
    @ResponseBody
    //http://localhost:8081/servlet/retrieve-all-Voyage 
    public List<Voyage> getVoyage() {
        List<Voyage> v = VoyageService.retrieveAllVoyage();
        return v ;
    }
    
    //http://localhost:8081/voyage/add-Voyage
    @PostMapping("/add-Voyage")
    @ResponseBody
    public ResponseEntity<?> addVoyage( @Valid  @RequestBody Voyage a , BindingResult result) {
        voyageValidatore.validate(a,result);
        ResponseEntity<?> erroMap =mapValidationErrorService.MapValidationService(result);
        if(erroMap != null)return erroMap;
        Voyage newVoyage = VoyageService.addVoyage(a);
        return new ResponseEntity<Voyage>( newVoyage, HttpStatus.CREATED);

    }
    @DeleteMapping("/remove-Voyage/{Voyage-id}")
    @ResponseBody
    public void removeVoyage(@PathVariable("Voyage-id")  long VoyageId) {
        VoyageService.DeleteVoyage(VoyageId);

    }

    @PutMapping("/modify-Voyage")
    @ResponseBody
    public Voyage modifyVoyage(@RequestBody Voyage cat) {
        return VoyageService.updateVoyage(cat);
    }


    @GetMapping("/retrieve-Voyage/{Voyage-id}")
    @ResponseBody
    public Voyage retrieveVoyage(@PathVariable("Voyage-id") int VoyageId) {
        return VoyageService.findVoyageById(VoyageId);  
    }
    //getrecommandation
    //http://localhost:8081/voyage/getrecommandation/4
    @GetMapping("/getrecommandation/{user-id}")
    @ResponseBody
    public String getRecommendation(@PathVariable("user-id") int userId) {
    	WebClient webClient = WebClient.create();
    	
    	/*MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();

    	bodyValues.add("note", "Run, Hike, Via ferrata");
    	bodyValues.add("price", "0");
    	bodyValues.add("date", "2015-03");
    	bodyValues.add("location", "Marrakech, Morroco");*/
    	
    	String note="Run, Hike, Via ferrata";
    	String price="0";
    	String date="2015-03";
    	String location="Marrakech, Morroco";
    	
    	User u = userService.findUserById(userId);
    	Preference p = preferenceService.getPreferenceByUser(u);
    	
    	String url="http://127.0.0.1:9000/api?note="+p.getObject()+"&price="+p.getPrice()+"&date="+date+"&location="+p.getDestination();
    	
    	System.out.println(url);
    	String response = webClient.get()
    		    .uri(url)
    		    .retrieve()
    		    .bodyToMono(String.class)
    		    .block();
    	
    	return response;
   }

}
