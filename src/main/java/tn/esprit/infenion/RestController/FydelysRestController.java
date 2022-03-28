package tn.esprit.infenion.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.infenion.Entities.Fydelys;
import tn.esprit.infenion.Entities.Reservation;
import tn.esprit.infenion.Entities.User;
import tn.esprit.infenion.Entities.Voyage;
import tn.esprit.infenion.IService.IFydelysService;
import tn.esprit.infenion.Service.FydelysService;

@RestController
@RequestMapping("/fydelys")
public class FydelysRestController {
	@Autowired
	IFydelysService Ifs;

 
}
