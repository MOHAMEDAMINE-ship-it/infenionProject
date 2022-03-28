package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString


public class Employee  implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmployee;
	
	@NonNull private String  email,password;
	@NonNull private int numTel;

	@NonNull private String FirstName, LastName;
	@NonNull private float salary;
	private boolean ban=false;
	private int nbre=0;
	
	//@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	@Temporal(TemporalType.DATE)
	@NonNull private java.util.Date dateNaissance;

	@Enumerated(EnumType.STRING)
	private Profession profession;
	
		
		//@JsonManagedReference
		@OneToMany(cascade = CascadeType.ALL, mappedBy="employees")
		private Set<Comment> comments;
		
		@OneToMany(cascade = CascadeType.REMOVE, mappedBy="employees")
		private Set<likes> likes;
		@ManyToOne
		private Entreprise entreprises;

		

		
		/*@JsonManagedReference(value = "employees")
		@ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "employees")
		private Set<Post> posts;*/

		

		
	
	
}
