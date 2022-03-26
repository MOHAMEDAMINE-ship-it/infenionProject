package com.esprit.pidev.service;

import java.util.List;

import com.esprit.pidev.entity.Role;
import com.esprit.pidev.entity.User;


public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    void deleteRoleToUser(String username, String roleName);

    User getUser(String username);
    List<User>getUsers();
}
