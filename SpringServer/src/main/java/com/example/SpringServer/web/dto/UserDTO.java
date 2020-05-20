package com.example.SpringServer.web.dto;

import com.example.SpringServer.web.model.Role;

import java.io.Serializable;
import java.util.Set;

public class UserDTO implements Serializable{

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Integer age;
    private String password;
//    private Set<Role> roles;
    private String roles;

    public UserDTO() {}
    public UserDTO(Long id) {
        this.id = id;
    }

//    public UserDTO(Long id, String email, String password, String firstname, String lastname, Integer age, Set<Role> roles) {
    public UserDTO(Long id, String email, String password, String firstname, String lastname, Integer age, String roles) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
        this.password = password;
        this.roles = roles;
    }

//    public UserDTO(String email, String password, String firstname, String lastname, Integer age, Set<Role> roles) {
    public UserDTO(String email, String password, String firstname, String lastname, Integer age, String roles) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
        this.password = password;
        this.roles = roles;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  /*  public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }*/

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
