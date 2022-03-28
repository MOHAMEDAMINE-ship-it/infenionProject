package tn.esprit.infenion.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import tn.esprit.infenion.Entities.Fydelys;
import tn.esprit.infenion.Entities.Reservation;
import tn.esprit.infenion.Entities.User;
import tn.esprit.infenion.Entities.Voyage;
import tn.esprit.infenion.IService.IFydelysService;
import tn.esprit.infenion.IService.IReservationService;
import tn.esprit.infenion.IService.IUserService;
import tn.esprit.infenion.IService.IVoyageService;
import tn.esprit.infenion.Repository.ReservationRepo;
import tn.esprit.infenion.Service.EmailSenderService;

import javax.validation.Valid;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationRestController {

    @Autowired
    IReservationService reservationService ;
    @Autowired
    IUserService userService ;
    @Autowired
    IVoyageService voyageService ;
    @Autowired
    IFydelysService fyl ;
    
    @Autowired
	private EmailSenderService service;
    
    //http://localhost:8081/reservation/

    @GetMapping("/retrieve-reservationByUser/{idu}")
    @ResponseBody
    public List<Reservation> getReservationByUser(@PathVariable("idu") long idu)  {
        List<Reservation> r = reservationService.retrieveAllReservationByUser(idu);
        return r;
    }

    @GetMapping("/retrieve-reservationByVoyage/{idu}")
    @ResponseBody
    public List<Reservation> getReservationByVoyage(@PathVariable("idu") long idu) {
        List<Reservation> r = reservationService.findReservationByVoyage(idu);
        return r;
    }
    
    //gestion de validator
    @PostMapping("/add-Reservation/{idu}/{idv}")
    @ResponseBody
    public Reservation addReservation(@RequestBody Reservation re,@PathVariable("idu")  long idu,@PathVariable("idv")  long idv) throws IOException {
        User u = userService.findUserById(idu);
        Voyage v = voyageService.findVoyageById(idv);
        
        
        if (fyl.findFydelysByUser(u) == null){
        	Fydelys f = new Fydelys();
            f.setPts(100);
            f.setPourcentage(0);
        	fyl.AddToFydelys(f, u);
        }
        else{
        	Fydelys fy = fyl.findFydelysByUser(u);
        	int points=fy.getPts()+100;
        	
        	if(points==1000) {
        		fy.setPts(0);
        		fy.setPourcentage(fy.getPourcentage()+10);
        	}
        	else {
        		fy.setPts(points);
        	}
        	
        	fyl.updateFydelys(fy);
        }
        
        Date date = new Date();
        re.setDateRes(date);
        re.setIduser(u);
        re.setIdV(v);
        
        ///send mail
        service.pdfCreation();
        service.sendSimpleEmail(u.getEmail(), "Client: "+u.getNom()+" voyage: "+v.getDestination()+" date: "+v.getDateDeparture()+" price: "+v.getPrice(),"Reservation confirmé");
        
        return reservationService.addReservation(re);
    }
    
    
    @DeleteMapping("/remove-reservation/{reservation-id}")
    @ResponseBody
    public void removeReservation(@PathVariable("reservation-id")  long reservation_id) {
        reservationService.DeleteReservation(reservation_id);

    }

    @PutMapping("/modify-Reservation")
    @ResponseBody
    public Reservation modifyReservation(@RequestBody Reservation cat) {
        return reservationService.updateReservation(cat);
    }

}
