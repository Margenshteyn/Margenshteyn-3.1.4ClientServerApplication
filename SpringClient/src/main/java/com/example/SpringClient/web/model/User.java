package com.example.SpringClient.web.model;

import com.example.SpringClient.web.dto.UserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User implements UserDetails {

    private Long id;
    private String firstname;
    private String lastname;
    private Integer age;
    private String email;
    private String password;
    private Set<Role> roles;

    public User() {
    }

    public User(Long id, String email, String password, String firstname, String lastname, Integer age, Set<Role> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.roles = roles;
    }

    public User(String email, String password, String firstname, String lastname, Integer age, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.roles = roles;
    }
    public User(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.firstname = userDTO.getFirstname();
        this.lastname = userDTO.getLastname();
        this.email = userDTO.getEmail();
        this.age = userDTO.getAge();
        this.password = userDTO.getPassword();
        this.roles = setRoles(userDTO.getRoles());
//        this.roles = userDTO.getRoles();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getUsername() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles.toString().replaceAll("\\p{P}", ""); // удаляет из ролей знаки пунктуации !"#$%&'()*+,-./:;<=>?@[\]^_\`{|}~
  /*      String rolesNew = roles.toString().replaceAll("[\\[\\]]", ""); // чтобы красиво отображалось в браузере
        return rolesNew.replaceAll(",", " "); // любой символ [ , и ]*/
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

// Принимаем строку с ролями из userDTO и распределяем роли для User
public Set<Role> setRoles(String role) {
    Set<Role> roles = new HashSet<>();
    try {
        String[] partsRole = role.split("[, ]");
        roles.add(new Role(partsRole[1]));
        roles.add(new Role(partsRole[0]));
        return this.roles = roles;
    } catch (Exception e) {

    }
    roles.add(new Role(role));
    return this.roles = roles;
}
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

 }
