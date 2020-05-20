package com.example.SpringClient.web.controller;

import com.example.SpringClient.web.dto.UserDTO;
import com.example.SpringClient.web.model.Role;
import com.example.SpringClient.web.model.User;
import com.example.SpringClient.web.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api/")
public class ClientRestController {

    private RestTemplateService restTemplateService;

    @Autowired
    public ClientRestController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/admin/allUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
         return new ResponseEntity<> (restTemplateService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/admin/addUser")
    public ResponseEntity<User> addUser(String email, String password, String firstname, String lastname, Integer age, String roles) {
//        Set<Role> roleSet = restTemplateService.getRoleForUser(roles);
//        restTemplateService.addUser(new UserDTO(email, password, firstname, lastname, age, roleSet));
        restTemplateService.addUser(new UserDTO(email, password, firstname, lastname, age, roles));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/admin/remove")
    public ResponseEntity<User> removeUser(Long id) {
        restTemplateService.removeUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
 /*   @DeleteMapping("/admin/remove")
    public ResponseEntity<User> removeUser(@RequestBody UserDTO userDTO) {
        restTemplateService.removeUser(userDTO.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

    @PutMapping("/admin/update")
    public ResponseEntity<User> updateUser(Long id, String email, String password, String firstname, String lastname, Integer age, String roles) {
//        password = userService.ifPasswordNull(id, password);
//        Set<Role> roleSet = restTemplateService.getRoleForUser(roles);
//        restTemplateService.updateUser(new UserDTO(id, email, password, firstname, lastname, age, roleSet));
        restTemplateService.updateUser(new UserDTO(id, email, password, firstname, lastname, age, roles));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/user/getUser")
    public ResponseEntity<List<User>> getUser(HttpSession session) {
        List<User> userList = new ArrayList<>();
        User user = (User) session.getAttribute("user");
        userList.add(user);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

}