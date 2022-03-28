package tn.esprit.spring.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// @RequiredArgsConstructor
@ToString

public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPost;
	private String title, body;
	//@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	@Temporal(TemporalType.DATE)
	@Column(name="datePost")
	private Date datePost;
	/*private int like=0;
	private boolean check = false;*/
	 
	//@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "posts")
	private Set<Comment> comments;
	
	
	
	/*@JsonBackReference(value = "employees")
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name="idEmployee", nullable=false)*/
	@ManyToOne
	private Employee employees;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "posts")
	private Set<likes> likes;

	

	




}
