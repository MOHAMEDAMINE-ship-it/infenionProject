package tn.esprit.spring.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.BadWords;
import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.repository.BadWordsRepo;
import tn.esprit.spring.repository.EmployeeRepository;

import tn.esprit.spring.repository.PostRepository;
@Service
public class PostsServiceImpl implements PostsService {
	@Autowired
	PostRepository postRepository;
	@Autowired
	EmployeeRepository emRepository;

	@Autowired
	BadWordsRepo badwords;
	
	@Autowired EmailService es;
	

	

	@Override
	public List<Post> retrieveAllPosts() {
		 List<Post>listpost= (List<Post>) postRepository.findAll();
		 return listpost; 
		
	}
	
	

	@Override
	public void addPosts(Post e,int idEmployee) {
		
		//e.setDatePost(now);
		 
		 
         Employee employee=emRepository.findById(idEmployee).get();
	     if(employee.getNbre()==4){
    		 
    		 employee.setBan(true);
    		 String msg= ("you've been banned because you've been using prohibited language more than 4 times which is against our user policy for further information contact us through our official email");
    		 es.sendMail("ahmed1998benromdhane@gmail.com", employee.getEmail(), "Alert", msg);
    	 }
         if(!employee.isBan()){
        	 
         String Body = e.getBody();
     	 String title=e.getTitle();
     	 List<BadWords> BadWordss = (List<BadWords>) badwords.findAll();
     	 boolean checkBody = checkBadWords(BadWordss,Body);
    	 boolean checkTitle = checkBadWords(BadWordss,title);
    	 if(employee.getNbre()<4)
    	 {
    	 if(checkBody == true || checkTitle == true)
    	 {
    			System.out.print("Offensive language detected, publication failed.");
    			int nbre=employee.getNbre()+1;
    			employee.setNbre(nbre);
    			emRepository.save(employee);
    			
    			
    			
    		}
    	 else if (checkBody == false || checkTitle== false ) 
    		{
    		
    		     e.setEmployees(employee);
    			 postRepository.save(e);
    		}
    		}
    
         }
         else System.out.println("This employee is banned");
         
	}
	

	
		 

	@Override
	public Post updatePosts(Post e,int idpost,int idEmp) {
		
		Employee client=emRepository.findById(idEmp).get();
		
		String Body = e.getBody();
		String title=e.getTitle();
		List<BadWords> BadWordss = (List<BadWords>) badwords.findAll();
		boolean checkBody = checkBadWords(BadWordss,Body);
		boolean checkTitle = checkBadWords(BadWordss,title);
		if(checkBody == true || checkTitle == true)
		{
			System.out.print("Prohibited language, publication failed.");
			
		}
		else if (checkBody == false && checkTitle== false ) 
		{
		e.setIdPost(idpost);
		e.setEmployees(client);
		return postRepository.save(e);
		}
		return e;
	}
	@Override
	public void deletePosts(int id) {
		
		postRepository.deleteById(id);
	}
	public boolean checkBadWords(List<BadWords> words, String message) 
	{
		
		int iterator=0;
		for(int i=0 ; i<words.size(); i++)
		{
			if (message.contains(words.get(i).getNom()))
			{
				iterator++; 
			}
		}
		if (iterator>0)
		{
			
			System.out.print("Your review contains offensive language, "+iterator+" inappropriate words found.");
			return true;
		}
		System.out.print("Your review is clean, valid and ready for publication.");
			return false;	
	}

	
	

	}
