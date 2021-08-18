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
}
