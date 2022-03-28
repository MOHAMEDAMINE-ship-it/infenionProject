package tn.esprit.infenion.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.infenion.Entities.Preference;
import tn.esprit.infenion.Entities.User;
import tn.esprit.infenion.IService.IPreferenceService;
import tn.esprit.infenion.Repository.PreferenceRepo;


@Service
public class PreferenceService implements IPreferenceService{
	@Autowired
	PreferenceRepo pr;
	
	@Override
	public Preference getPreferenceByUser(User u) {
		return pr.findPreferenceByUser(u);
	}

}
