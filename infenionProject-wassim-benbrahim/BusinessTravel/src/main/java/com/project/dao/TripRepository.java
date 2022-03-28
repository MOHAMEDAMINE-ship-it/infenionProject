package com.project.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.Trip;



@Repository
public interface TripRepository extends CrudRepository<Trip,Long>{

}



