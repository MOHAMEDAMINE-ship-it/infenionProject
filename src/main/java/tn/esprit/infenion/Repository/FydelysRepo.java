package tn.esprit.infenion.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.infenion.Entities.Fydelys;
import tn.esprit.infenion.Entities.User;
@Repository
public interface FydelysRepo extends CrudRepository<Fydelys, Long>{

	Fydelys findFydelysByIduser(User u);
}
