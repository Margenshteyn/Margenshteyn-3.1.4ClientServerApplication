package com.example.SpringClient.web.service;

import com.example.SpringClient.web.dto.UserDTO;
import com.example.SpringClient.web.model.Role;
import com.example.SpringClient.web.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface RestTemplateService {

    public List<UserDTO> getAllUsers();

    public UserDTO addUser(UserDTO userDTO);

    public UserDTO updateUser(UserDTO userDTO);

//    public void removeUser(UserDTO userDTO);
    public void removeUser(Long id);

    public Set<Role> getRoleForUser(String roles);

/*    UserDTO getUserById(long id);

    public User getUserByEmail(String email);

    public void addFirstAdminAndUser();

    public Set<Role> getRoleForUser(String roles);

    public boolean userExist(String email);

//    public String ifPasswordNull(Long id, String password);*/
}
