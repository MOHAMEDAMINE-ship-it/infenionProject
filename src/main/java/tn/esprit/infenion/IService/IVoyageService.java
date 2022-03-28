package tn.esprit.infenion.IService;

import java.util.List;

import tn.esprit.infenion.Entities.Voyage;

public interface IVoyageService {

    Voyage addVoyage(Voyage Voyage);

    String DeleteVoyage(long VoyageId);

    Voyage updateVoyage(Voyage Voyage);

    List<Voyage> retrieveAllVoyage();

    Voyage findVoyageById(long id);
}
