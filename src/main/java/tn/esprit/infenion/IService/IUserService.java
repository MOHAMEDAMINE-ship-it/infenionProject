package tn.esprit.infenion.IService;

import java.util.List;

import tn.esprit.infenion.Entities.Reservation;
import tn.esprit.infenion.Entities.User;

public interface IUserService {

    
    User addUser(User User);

    String DeleteUser(long UserId);

    User updateUser(User User);

    List<User> retrieveAllUserByUser();

    List<User> retrieveAllUserByUser(long idU);
    User findUserById(long id);

    
}
