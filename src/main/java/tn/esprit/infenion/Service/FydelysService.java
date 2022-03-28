package tn.esprit.infenion.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.infenion.Entities.Fydelys;
import tn.esprit.infenion.Entities.User;
import tn.esprit.infenion.Entities.Voyage;
import tn.esprit.infenion.IService.IFydelysService;
import tn.esprit.infenion.Repository.FydelysRepo;
@Service
public class FydelysService implements IFydelysService{
	@Autowired
	FydelysRepo Fr;

	@Override
	public Fydelys AddToFydelys (Fydelys Fydelys, User u) {
		 Fydelys.setIduser(u);
		 return Fr.save(Fydelys);
		
	}

	@Override
	public String DeleteFydelys(long IdFyd) {
		Fr.delete(Fr.findById((long) IdFyd).get());
        return "Deleted";
	}

	@Override
	public Fydelys updateFydelys(Fydelys Fydelys) {
		return Fr.save(Fydelys);
	}

	@Override
	public List<Fydelys> retrieveAllFydelys() {
		List<Fydelys> categories=(List<Fydelys>)Fr.findAll();
        return categories;
	}

	@Override
	public Fydelys findFydelysById(long idFyd) {
		 return this.Fr.findById(idFyd).orElse(null);
	}

	@Override
	public Fydelys findFydelysByUser(User u) {
		return Fr.findFydelysByIduser(u);
	}
	

}
