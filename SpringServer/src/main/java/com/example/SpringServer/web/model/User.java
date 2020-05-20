package com.example.SpringServer.web.model;


import com.example.SpringServer.web.dto.UserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstname;

    @Column(name = "lastName")
    private String lastname;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
  /* public Set<Role> setRoles(String roles) {
       Set<Role> rolesSet = new HashSet<>();
       try {
           String[] partsRole = roles.split(",");
           for (String role : partsRole) {
               rolesSet.add(new Role(role));
           }
           return rolesSet;
       } catch (Exception e) {
           e.printStackTrace();
       }
       rolesSet.add(new Role(roles));
//       return rolesSet;
       return this.roles = rolesSet;
   }*/

 /*   @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getEmail().equals(user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail());
    }*/
}
