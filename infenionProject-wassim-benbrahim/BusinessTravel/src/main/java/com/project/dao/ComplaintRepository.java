package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.Complaint;
import com.project.entities.User;

import java.util.Date;

public interface ComplaintRepository extends JpaRepository<Complaint,Long> {
public boolean existsComplaintByComplainer(User user);

}
