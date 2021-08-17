package com.example.jdpc_in_best_practice.model;

import lombok.Data;

@Data
public class StudentDto {
    private String username;
    private String password;
    private String fullname;
    private boolean role;
    private int idCourse;
}
