package tn.esprit.infenion.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.infenion.Entities.Voyage;
import tn.esprit.infenion.IService.IVoyageService;
import tn.esprit.infenion.Repository.VoyageRepo;

import java.util.List;

@Service
public class VoyageService implements IVoyageService {

    @Autowired
    VoyageRepo voyageRepo ;


    @Override
    public Voyage addVoyage(Voyage Voyage) {
         return voyageRepo.save(Voyage);
    }

    @Override
    public String DeleteVoyage(long VoyageId) {
        voyageRepo.delete(voyageRepo.findById((long) VoyageId).get());
        return "Deleted";
    }

    @Override
    public Voyage updateVoyage(Voyage Voyage) {
        return voyageRepo.save(Voyage);
    }

    @Override
    public List<Voyage> retrieveAllVoyage() {
        List<Voyage> categories=(List<Voyage>)voyageRepo.findAll();
        return categories;
    }

    @Override
    public Voyage findVoyageById(long id) {
        return this.voyageRepo.findById(id).orElse(null);

    }
}
