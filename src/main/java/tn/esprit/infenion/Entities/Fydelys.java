package tn.esprit.infenion.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Fydelys {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idFyd;

	private int pts ;
	
	private int pourcentage;

	
	
	public int getPts() {
		return pts;
	}
	public void setPts(int pts) {
		this.pts = pts;
	}
	public long getIdFyd() {
		return idFyd;
	}
	public void setIdFyd(long idFyd) {
		this.idFyd = idFyd;
	}
	
    @ManyToOne
    @JoinColumn(name="iduser",referencedColumnName = "iduser")
    private User iduser;


	public User getIduser() {
		return iduser;
	}
	public void setIduser(User iduser) {
		this.iduser = iduser;
	}
	
	
	public int getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(int pourcentage) {
		this.pourcentage = pourcentage;
	}
    
    

	
	
	
	

}
