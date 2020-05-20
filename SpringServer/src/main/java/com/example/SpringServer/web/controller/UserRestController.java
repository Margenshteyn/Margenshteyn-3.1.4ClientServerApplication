package com.example.SpringServer.web.controller;


import com.example.SpringServer.web.dto.UserDTO;
import com.example.SpringServer.web.model.Role;
import com.example.SpringServer.web.model.User;
import com.example.SpringServer.web.service.UserService;
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
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/allUsers")
//    @PostMapping("/admin/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
         return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/admin/addUser")
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO){
        userService.addUser(new User(userDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/admin/remove")
    public void removeUser(Long id) {
        userService.removeUser(id);
    }
 /*   @DeleteMapping("/admin/remove")
    public ResponseEntity<User> removeUser(@RequestBody UserDTO userDTO) {
        userService.removeUser(userDTO.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

    @PutMapping("/admin/update")
    public ResponseEntity<User> updateUser(@RequestBody UserDTO userDTO) {
//        password = userService.ifPasswordNull(id, password);
        userService.updateUser(new User(userDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/user/getUser")
    public ResponseEntity<User> getUser(String email) {
//        userService.addFirstAdminAndUser();
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }

}