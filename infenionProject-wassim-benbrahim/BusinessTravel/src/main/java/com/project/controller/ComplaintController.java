package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.dao.ComplaintRepository;
import com.project.entities.Complaint;
import com.project.entities.Topic;
import com.project.serviceImpl.ComplaintService;

import tn.esprit.spring.exceptions.ResourceNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/Complaint")
public class ComplaintController {

    @Autowired
    ComplaintService cs;
    @Autowired
    ComplaintRepository repo;

    @GetMapping("/retrieve-all-reclamations")
    @ResponseBody
    public List<Complaint> getReclamations() {
        return cs.retrieveAllReclamations();
    }

//    @GetMapping("/retrieve-reclamation/{reclamation-id}")
//    @ResponseBody
//    public Complaint retrieveReclamation(@PathVariable("reclamation-id") Long id) {
//        return cs.retrieveReclamation(id);
//    }
    @GetMapping("/retreive-claimById/{id}")
    public ResponseEntity<Complaint> retrieveReclamation(@PathVariable Long id) throws ResourceNotFoundException {
    	 Optional<Complaint> optionalClaim = cs.retrieveReclamation(id);
    	 if (!optionalClaim.isPresent()) {
    	      throw new ResourceNotFoundException("No Claim found with the id:" + id);
    	    }	
    	return  new ResponseEntity<>(optionalClaim.get(), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/add/{id_complainer}/{id_complained}/{id_trip}")
    public Complaint add_complaint( @RequestBody Complaint c ,@PathVariable("id_complainer") Long Id_sender
            ,@PathVariable("id_complained") Long id_complained , @PathVariable ("id_trip") Long id_trip ){
        return cs.add_complaint(c, Id_sender, id_complained, id_trip);
    }


//    @ResponseBody
//    @PostMapping("/add_complaint/{id_complainer}/{id_complained}/{id_trip}")
//    public ResponseEntity<Complaint> addCompmlaint(@Valid  @RequestBody Complaint c ,@PathVariable("id_complainer") Long Id_sender
//            ,@PathVariable("id_complained") Long id_complained , @PathVariable ("id_trip") Long id_trip ){
//       Complaint x= cs.add_complaint(c, Id_sender, id_complained, id_trip);
//       return  new ResponseEntity<Complaint>(x,HttpStatus.CREATED);
//    }
    @DeleteMapping("/delete-claim/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteClaim(@PathVariable Long id) throws ResourceNotFoundException{
    	 Optional<Complaint> optionalClaim  = repo.findById(id);
    	 if (!optionalClaim.isPresent()) {
    	      throw new ResourceNotFoundException("No Claim found with the id: " + id);
    	    }	
    	
    	repo.delete(optionalClaim.get());
    	Map<String, Boolean> response = new HashMap<>();
    	response.put("deleted", Boolean.TRUE);
    	return ResponseEntity.ok(response);
    }


    @DeleteMapping("/delete/{id}")
    public void delete_complaint(@PathVariable("id") Long id_Complaint){
        cs.Delete_complaint(id_Complaint);
    }

    @GetMapping("/By/{topic}")
    public List<Complaint> FilterByTopic(@PathVariable("topic") Topic topic){
        return cs.FilterByTopic(topic);
    }

    @GetMapping("/most_topic")
    @ResponseBody
    public Topic most_topic_complained(){
        return cs.most_topic_complained();
    }

    @GetMapping("/triByUser")
    @ResponseBody
    public Map<Long, Long> triByUser(){
        return cs.triByUser();
    }
    @GetMapping("/nbr/{id}")
    @ResponseBody
    public Long nbr_complaints_recieved_each_week(@PathVariable("id") Long id_user){
      return   cs.nbr_complaints_recieved_each_week(id_user);
    }

    @ResponseBody
    @PostMapping("/attribute")
    public void attribute_employee_type(){
        cs.attribute_employee_type();
    }

    @ResponseBody
    @GetMapping("/month")
    public int Taux_complaints_each_month(){
        return cs.Taux_complaints_each_month();
    }

    }
