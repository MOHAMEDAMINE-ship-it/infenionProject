package tn.esprit.infenion.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity
@Table(name="voyage")
public class Voyage {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idVoyage;

    @NotBlank (message = "Destination ne doit pas étre vide")
    private String destination ;

    private Oject object ;

    private Date dateDeparture ;

    private Date arrivalDate ;

    private Float price ;

    public Long getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(Long idVoyage) {
        this.idVoyage = idVoyage;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Oject getObject() {
        return object;
    }

    public void setObject(Oject object) {
        this.object = object;
    }



    public Date getDateDeparture() {
		return dateDeparture;
	}

	public void setDateDeparture(Date dateDeparture) {
		this.dateDeparture = dateDeparture;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Voyage() {
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    
}
