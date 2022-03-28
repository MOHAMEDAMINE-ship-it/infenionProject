package tn.esprit.infenion.IService;

import java.util.List;

import tn.esprit.infenion.Entities.Reservation;

public interface IReservationService {


    Reservation addReservation(Reservation Reservation);

    String DeleteReservation(long ReservationId);

    Reservation updateReservation(Reservation Reservation);

    List<Reservation> retrieveAllReservationByUser(long idU);

    List<Reservation> findReservationByVoyage( long idV);}
