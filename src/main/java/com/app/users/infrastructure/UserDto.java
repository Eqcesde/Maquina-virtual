package com.app.users.infrastructure;

import java.time.LocalDate;

public class UserDto {
    private Long id;
    private String name;
    private String last_name;
    private String email;
    private String password;
    private LocalDate date;

    // Empty constructor
    public UserDto() {
    }

    // Constructor with parameters
    public UserDto(Long id, String name, String last_name, String email, String password, LocalDate date) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.date = date;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // toString() method
    @Override
    public String toString() {
    return "UserDto{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", last_name='" + last_name + '\'' +
            ", email='" + email + '\'' +
            ", date=" + date +
            '}';
        } 
}

