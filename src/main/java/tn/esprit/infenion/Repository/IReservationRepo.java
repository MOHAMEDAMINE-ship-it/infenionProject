package tn.esprit.infenion.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.infenion.Entities.Reservation;
import tn.esprit.infenion.Entities.User;
import tn.esprit.infenion.Entities.Voyage;

import java.util.List;

@Repository
public interface IReservationRepo  extends CrudRepository<Reservation,Long> {

    List<Reservation> findReservationByIduser( User iduser );
    List<Reservation> findReservationByIdV( Voyage idv );
}
