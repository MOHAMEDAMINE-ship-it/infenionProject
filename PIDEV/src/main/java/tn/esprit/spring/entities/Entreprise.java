package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;





@Entity
@ToString



public class Entreprise   implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEntreprise;
	
	 private String nomEntreprise,email;
	 private int numTel;
	 @Enumerated(EnumType.STRING)
	 private Domain domain;



	 @JsonIgnore
     @OneToMany(cascade = CascadeType.ALL, mappedBy="entreprises")
     private Set<Employee> employees;



	public int getIdEntreprise() {
		return idEntreprise;
	}



	public void setIdEntreprise(int idEntreprise) {
		this.idEntreprise = idEntreprise;
	}



	public String getNomEntreprise() {
		return nomEntreprise;
	}



	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	



	public int getNumTel() {
		return numTel;
	}



	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}



	public Domain getDomain() {
		return domain;
	}



	public void setDomain(Domain domain) {
		this.domain = domain;
	}



	public Set<Employee> getEmployees() {
		return employees;
	}



	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}




    


	
	 
}
