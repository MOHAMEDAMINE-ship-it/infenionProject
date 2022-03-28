package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Post;

public interface PostsService {
	List<Post> retrieveAllPosts();

	void addPosts(Post e,int idUser);
	Post updatePosts(Post e,int idpost,int idEmp);
	void deletePosts(int id);
	
	

}
