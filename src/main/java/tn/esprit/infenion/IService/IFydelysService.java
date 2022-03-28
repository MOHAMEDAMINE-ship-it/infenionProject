package tn.esprit.infenion.IService;

import java.util.List;

import tn.esprit.infenion.Entities.Fydelys;
import tn.esprit.infenion.Entities.User;
import tn.esprit.infenion.Entities.Voyage;


public interface IFydelysService {
	
	Fydelys AddToFydelys (Fydelys Fydelys, User u);
	
    String DeleteFydelys(long IdFyd);

    Fydelys updateFydelys(Fydelys Fydelys);

    List<Fydelys> retrieveAllFydelys();

    Fydelys findFydelysById(long idFyd);
   
    Fydelys findFydelysByUser(User idFyd);

}
