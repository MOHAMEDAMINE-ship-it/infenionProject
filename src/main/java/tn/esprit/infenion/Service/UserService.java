package tn.esprit.infenion.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.infenion.Entities.Reservation;
import tn.esprit.infenion.Entities.User;
import tn.esprit.infenion.Entities.Voyage;
import tn.esprit.infenion.IService.IUserService;
import tn.esprit.infenion.Repository.UserRepo;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepo userRepo ;

    @Override
    public User findUserById(long id) {
        return this.userRepo.findById(id).orElse(null);
    }

	@Override
	public User addUser(User User) {
	         return userRepo.save(User);
	}

	@Override
	public String DeleteUser(long iduser) {
		userRepo.delete(userRepo.findById((long) iduser).get());
        return "Deleted";
	}

	@Override
	public User updateUser(User User) {
		return userRepo.save(User);
	}

	@Override
	public List<User> retrieveAllUserByUser(long idU) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> retrieveAllUserByUser() {
		return (List<User>) userRepo.findAll();
   
	}
}
