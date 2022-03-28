package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Post;

import tn.esprit.spring.service.PostsService;

@RestController
@RequestMapping("/post")
public class PostRestController {
	@Autowired
	PostsService postservice;
	
	
	@GetMapping("/retrive-posts")
	public List<Post> getPosts() {
		List<Post> listPost = postservice.retrieveAllPosts();
		return listPost;
		
	}
	
	// http://localhost:8081/SpringMVC/post/add-post/1
	
	@PostMapping("/add-post/{Employee_id}")
	public void AddPost(@RequestBody Post p,@PathVariable("Employee_id") int employeeid)
	{
		postservice.addPosts(p,employeeid);
	}
	
	// http://localhost:8081/SpringMVC/post/modify-post
	
	@PutMapping("/modify-post/{post-Id}/{employee_id}")
	public void modifyEmployee(@RequestBody Post e,@PathVariable("post-Id") int postId,@PathVariable("employee_id") int employeeid) {
		postservice.updatePosts(e,postId,employeeid);
	}
	
	// http://localhost:8081/SpringMVC/post/remove-post/1
	@DeleteMapping("/remove-post/{post-id}")
	public void removeEmployee(@PathVariable("post-id") int employeeId) {
		postservice.deletePosts(employeeId);
	}
	/*
		@PutMapping("/modify-post/{post-Id}/{user_id}")
		public void modifyEmployee(@RequestBody Post e,@PathVariable("post-Id") int postId,@PathVariable("user_id") int userid) {
			postxervice.updatePosts(e,postId,userid);
		}
		
		@GetMapping("/retrive-employe-with-most-posts")
		public Employee getEmployeWithMostPosts() {
			Employee emp = postxervice.retrieveBestPosts();
			return emp;
			
		}
		@GetMapping("/retrive-Posts-with-most-likes")
		public Post getMostPosts() {
			Post post =postxervice.retrieveBestPosts1() ;
			return post;
		
	}
		@PostMapping("/send")
		public void get() {
			postxervice.sendMAil();
			
			}*/
}
	
	


