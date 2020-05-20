package com.example.SpringServer.web.service;

import com.example.SpringServer.web.model.Role;
import com.example.SpringServer.web.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    public List<User> getAllUsers();

    public boolean addUser(User user);

    public boolean updateUser(User user);

    public void removeUser(Long id);

    public User getUserById(Long id);

    public User getUserByEmail(String email);

    public void addFirstAdminAndUser();

    public Set<Role> getRoleForUser(String roles);

    public boolean userExist(String email);

//    public String ifPasswordNull(Long id, String password);
}
