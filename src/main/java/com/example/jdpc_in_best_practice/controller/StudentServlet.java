package com.example.jdpc_in_best_practice.controller;

import com.example.jdpc_in_best_practice.model.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "student", value = "/student")
public class StudentServlet extends HttpServlet {

    StudentDao studentDao = StudentDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        List<String> list = studentDao.getListStudent();
        for (int i = 0; i < list.size(); i++) {
            out.println(String.format("Student #%5d | %8s ", i + 1, list.get(i)));
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
