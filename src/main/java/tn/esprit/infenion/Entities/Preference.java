package tn.esprit.infenion.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Preference {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idPre;

	private String destination;
	private int price;
	private String object;

	
    @ManyToOne
    @JoinColumn(name="iduser",referencedColumnName = "iduser")
    private User iduser;


	public User getIduser() {
		return iduser;
	}
	public void setIduser(User iduser) {
		this.iduser = iduser;
	}
	public long getIdPre() {
		return idPre;
	}
	public void setIdPre(long idPre) {
		this.idPre = idPre;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	
	
	
    

	
	
	
	

}
