package com.example.jdpc_in_best_practice.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentDto implements Serializable {
    private String username;
    private String password;
    private String fullname;
    private boolean role;
    private int idCourse;

    public StudentDto() {
    }

    public StudentDto(String username, String fullname, boolean role) {
        this.username = username;
        this.fullname = fullname;
        this.role = role;
    }

    public StudentDto setFullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public StudentDto setRole(boolean role) {
        this.role = role;
        return this;
    }

    public StudentDto setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%8s|%8s|%b", username, fullname, role);
    }
}
