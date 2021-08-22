package com.example.jdpc_in_best_practice.model.service;

import com.example.jdpc_in_best_practice.dbutil.config.ConcreteDatasource;
import com.example.jdpc_in_best_practice.model.StudentDto;
import org.junit.jupiter.api.Test;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

class StudentServiceTest {
    private final StudentService service = new StudentDao(ConcreteDatasource.getInstance());

    @Test
    void testGetAllList() {
        try {
            List<StudentDto> listStudent = service.getListStudent();
            listStudent.forEach(System.out::println);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }

    @Test
    void searchStudentTest() {
        try {
            service.searchStudent("duc").ifPresent(System.out::println);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}