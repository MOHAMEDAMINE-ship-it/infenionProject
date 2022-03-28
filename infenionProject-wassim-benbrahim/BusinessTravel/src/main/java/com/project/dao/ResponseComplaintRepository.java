package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.ResponseComplaint;



@Repository
public interface ResponseComplaintRepository extends JpaRepository<ResponseComplaint,Long> {

}
