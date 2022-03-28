package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Post;

import tn.esprit.spring.repository.CommentRepository;
import tn.esprit.spring.repository.EmployeeRepository;
import tn.esprit.spring.repository.PostRepository;
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentRepository CommentRepository;
	@Autowired
	EmployeeRepository emRepository;
	@Autowired
	PostRepository postRepository;
	@Override
	public List<Comment> retrieveAllComment() {
		// TODO Auto-generated method stub
		return  (List<Comment>) CommentRepository.findAll();
		}

	@Override
	public void addCommentt(Comment e) {
		// TODO Auto-generated method stub
		
		CommentRepository.save(e);
	}

	@Override
	public void deletePosts(int id) {
		
		CommentRepository.deleteById(id);
	}

	@Override
	public void updateComment(Comment e,int id) {
		// TODO Auto-generated method stub
		
		e.setIdComment(id);
		CommentRepository.save(e);
	}


	@Override
	public Comment retrieveCooment(int id) {
		Comment comment = CommentRepository.findById(id).get();
		return comment ;
	}

	@Override
	
	public void addComment(Comment e,int idpost,int iduser) {
		
		Post p = postRepository.findById(idpost).orElse(null);
		Employee c=emRepository.findById(iduser).orElse(null);
		e.setPosts(p);
		e.setEmployees(c);
		CommentRepository.save(e);
		
	}

	//}

}
