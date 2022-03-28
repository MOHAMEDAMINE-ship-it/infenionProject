package tn.esprit.infenion.IService;

import tn.esprit.infenion.Entities.Preference;
import tn.esprit.infenion.Entities.User;

public interface IPreferenceService {
	Preference getPreferenceByUser(User u);
}
