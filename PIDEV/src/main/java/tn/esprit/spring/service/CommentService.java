package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Post;

public interface CommentService {
	List<Comment> retrieveAllComment();

	void addComment(Comment e,int idpost ,int iduser);
	void deletePosts(int id);

	void updateComment(Comment e,int id);
	public void addCommentt(Comment e);
	public Comment retrieveCooment(int id) ;

	
}
