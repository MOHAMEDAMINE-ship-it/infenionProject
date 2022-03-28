package tn.esprit.infenion.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.infenion.Entities.Fydelys;
import tn.esprit.infenion.Entities.Preference;
import tn.esprit.infenion.Entities.User;

@Repository
public interface PreferenceRepo extends CrudRepository<Preference,Long> {
	
	@Query("SELECT p FROM Preference p WHERE p.iduser = ?1")
	public Preference findPreferenceByUser(User u);
}