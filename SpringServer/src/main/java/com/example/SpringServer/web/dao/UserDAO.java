package com.example.SpringServer.web.dao;



import com.example.SpringServer.web.model.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();

    public void addUser(User user);

    public void updateUser(User user);

    public void removeUser(Long id);

    public User getUserById(Long id);

    public User getUserByEmail(String email);

    boolean userExist(String email);

}
