package tn.esprit.infenion.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.infenion.Entities.User;
import tn.esprit.infenion.IService.IUserService;


@RestController
@RequestMapping("/user")
public class UserRestController {
	@Autowired
    IUserService userserv;
	
	 @GetMapping("/retrieve-all-User")
	    @ResponseBody
	    //http://localhost:8081/SpringMVC/servlet/retrieve-all-User
	    public List<User> getUser() {
	        List<User> u = userserv.retrieveAllUserByUser();
	        return u ;
	        
	 }
	        
	       
	        
	        
}
