package com.example.jdpc_in_best_practice.model.service;

import com.example.jdpc_in_best_practice.model.StudentDto;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentDto> getListStudent() throws SQLException, NamingException;

    Optional<StudentDto> searchStudent(String search) throws SQLException, NamingException;

    Optional<StudentDto> save(StudentDto studentDto) throws SQLException, NamingException;

}
