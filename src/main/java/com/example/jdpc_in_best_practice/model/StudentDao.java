package com.example.jdpc_in_best_practice.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements Serializable {
    private final DataSource datasource;
    private static final StudentDao studentDao = new StudentDao();

    private StudentDao() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:comp/env");
            datasource = (DataSource) envContext.lookup("jdbc/Student");
        } catch (Exception e) {
            throw new RuntimeException("Datasource calling went wrong: " + e.getMessage());
        }
    }

    public static StudentDao getInstance() {
        return studentDao;
    }

    public List<String> getListStudent() {
        List<String> username = new ArrayList<>();
        String sql = "SELECT username from Student";
        try (Connection con = datasource.getConnection();
             Statement state = con.createStatement();
             ResultSet rs = state.executeQuery(sql)) {
            while (rs.next()) {
                username.add(rs.getString("username"));
            }
            return username;
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong: " + e.getMessage());
        }
    }

}
