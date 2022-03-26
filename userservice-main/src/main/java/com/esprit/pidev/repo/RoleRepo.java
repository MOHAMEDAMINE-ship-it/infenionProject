package com.esprit.pidev.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.pidev.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
