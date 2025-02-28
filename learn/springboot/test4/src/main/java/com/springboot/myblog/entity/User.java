package com.springboot.myblog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String firstName;
    private String lastName;
    private String description;
    public Long getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getDescription() {
        return description;
    }
    public User setId(Long id) {
        this.id = id;
        return this;
    }
    public User setLogin(String login) {
        this.login = login;
        return this;
    }
    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public User setDescription(String description) {
        this.description = description;
        return this;
    }
}
