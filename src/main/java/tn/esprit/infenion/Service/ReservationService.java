package tn.esprit.infenion.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.infenion.Entities.Reservation;
import tn.esprit.infenion.Entities.User;
import tn.esprit.infenion.Entities.Voyage;
import tn.esprit.infenion.IService.IReservationService;
import tn.esprit.infenion.IService.IUserService;
import tn.esprit.infenion.IService.IVoyageService;
import tn.esprit.infenion.Repository.ReservationRepo;

import java.util.List;

@Service
public class ReservationService implements IReservationService {
    @Autowired
    ReservationRepo reservationRepo ;
    @Autowired
    IVoyageService voyageService ;
    @Autowired
    IUserService userService ;
    @Override
    public Reservation addReservation(Reservation Reservation) {
        return reservationRepo.save(Reservation);
    }

    @Override
    public String DeleteReservation(long ReservationId) {
        reservationRepo.delete(reservationRepo.findById((long) ReservationId).get());
        return "Deleted";
    }

    @Override
    public Reservation updateReservation(Reservation Reservation) {
        return reservationRepo.save(Reservation);
    }

    @Override
    public List<Reservation> retrieveAllReservationByUser(long idU) {
        User u = userService.findUserById(idU);
        return reservationRepo.findReservationByIduser(u);
    }

    @Override
    public List<Reservation> findReservationByVoyage(long idV) {
        Voyage v = voyageService.findVoyageById(idV);
        return reservationRepo.findReservationByIdV(v);
    }
}
