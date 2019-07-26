package com.gmail.morovo1988.projectShop.model;

import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator", sequenceName = "users_sequence", initialValue = 20,  allocationSize = 1)
    private Long id;

    @Size(max = 50)
    @NotBlank(message = "must not be blank")
    @NotNull
    @Column(name = "name", length = 50)
    private String name;

    @NotBlank(message = "must not be blank")
    @NotNull
    @Column(name = "password", length = 60)
//    @JsonIgnore
    private String password;

    @NotNull
    @Email
    @NotBlank(message = "must not be blank")
    @Column(length = 100, unique = true)
    private String email;

    @NotBlank(message = "must not be blank")
    @NotNull
    @Column(name = "telephone", length = 20)
    private String telephone;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roles_name", referencedColumnName = "name")
    )
    @BatchSize(size = 20)
//    @JsonIgnore
    private Set<Role> roles = new HashSet<>();

      public User() {
    }

    public User(@Size(max = 50) String name, String password, @NotNull @NotBlank(message = "must not be blank") String email, String telephone) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
    }

    public User(@Size(max = 50) String name, String password, @NotNull @NotBlank(message = "must not be blank") String email, String telephone, Set<Role> roles) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
        this.roles = roles;
    }



    public void addRole(Role role) {
        this.roles.add(role);
    }

    public Long getId() {    return id;    }

    public void setId(Long id) {        this.id = id;    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(telephone, user.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, email, telephone);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", roles=" + roles +
                '}';
    }
}
