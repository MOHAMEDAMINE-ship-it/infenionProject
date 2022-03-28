package tn.esprit.infenion.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.infenion.Entities.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
}
