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

import tn.esprit.spring.service.CommentService;
import tn.esprit.spring.service.CommentServiceImpl;
@RestController
@RequestMapping("/comment")
public class CommentRestController {
	@Autowired
	CommentServiceImpl commentservice;
	// http://localhost:8081/SpringMVC/comment/retrieve-comments/1
			
			@GetMapping("/retrieve-comments/{Post-id}")
			public Comment getComments(@PathVariable("Post-id") int postId) {
				Comment listComment = commentservice.retrieveCooment(postId);
				return listComment;
			}
			
	// http://localhost:8081/SpringMVC/comment/add-Comment/1/1
			@PostMapping("/add-Comment/{Post-id}/{user-id}")
			public void addComment(@RequestBody Comment e,@PathVariable("Post-id") int postIdi,@PathVariable("user-id") int postIdu) {
				//System.out.print(e.toString());
				commentservice.addComment(e,postIdi,postIdu);
				
			}
			// http://localhost:8089/SpringMVC/task/remove-task/1
			@DeleteMapping("/remove-Comment/{Comment-id}")
			public void remove(@PathVariable("Comment-id") int postId) {
				commentservice.deletePosts(postId);
			}
	
			@GetMapping("/retrieve-Allcomments")
			public List<Comment> getallComments() {
				List<Comment> listComment = commentservice.retrieveAllComment();
				return listComment;
			}
			// http://localhost:8081/SpringMVC/employee/modify-employee
			@PutMapping("/modify-comment/{Comment-Id}")
			public void modifyEmployee(@RequestBody Comment e,@PathVariable("Comment-Id") int postId) {
				commentservice.updateComment(e,postId);
			}
			@PostMapping("/add-Comment")
			public void addComment(@RequestBody Comment e) {
				//System.out.print(e.toString());
				//commentservice.addComment1(e);
				
			}
			
}