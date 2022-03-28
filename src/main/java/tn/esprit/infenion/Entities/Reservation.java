package tn.esprit.infenion.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idReservation;

    private Date dateRes ;

    @ManyToOne
    @JoinColumn(name="iduser",referencedColumnName = "iduser")
    private User iduser;

    @ManyToOne
    @JoinColumn(name="idV",referencedColumnName = "idVoyage")
    private Voyage idV;

    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public Date getDateRes() {
        return dateRes;
    }

    public void setDateRes(Date dateRes) {
        this.dateRes = dateRes;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public Voyage getIdV() {
        return idV;
    }

    public void setIdV(Voyage idV) {
        this.idV = idV;
    }

    public Reservation() {
    }
}

