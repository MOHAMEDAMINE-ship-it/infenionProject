package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

public class Comment  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComment;
	 private String body;

	 private java.util.Date dateComment;
	//@ToString.Exclude

//	@JsonBackReference
	//@JoinColumn(name="idPost", nullable=false)
	@ManyToOne
	private Post posts;
	
	//@JsonBackReference

	//@JoinColumn(name="idEmployee", nullable=false)
	@ManyToOne
	private Employee employees;

	public int getIdComment() {
		return idComment;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public java.util.Date getDateComment() {
		return dateComment;
	}

	public void setDateComment(java.util.Date dateComment) {
		this.dateComment = dateComment;
	}

	public Post getPosts() {
		return posts;
	}

	public void setPosts(Post posts) {
		this.posts = posts;
	}

	public Employee getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
