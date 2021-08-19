package com.example.jdpc_in_best_practice.model.service;

import com.example.jdpc_in_best_practice.dbutil.ConnectionHelper;
import com.example.jdpc_in_best_practice.dbutil.SuppliedConnectionHelper;
import com.example.jdpc_in_best_practice.dbutil.tomcatconfig.TomcatDatasource;
import com.example.jdpc_in_best_practice.model.StudentDto;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class StudentDao implements StudentService {
    private final ConnectionHelper connectionHelper = new SuppliedConnectionHelper(TomcatDatasource.getInstance());

    public List<StudentDto> getListStudent() throws SQLException, NamingException {
        List<StudentDto> list = new ArrayList<>();
        String sql = "SELECT username from Student";
        try (Connection con = connectionHelper.getConnection();
             Statement state = con.createStatement();
             ResultSet rs = state.executeQuery(sql)) {
            while (rs.next()) {
                String _username = rs.getString("username");
                String _fullname = rs.getString("fullname");
                boolean role = rs.getBoolean("role");
                list.add(new StudentDto(_username, _fullname, role));
            }
        }
        return list;
    }

    @Override
    public Optional<StudentDto> searchStudent(String username) throws SQLException, NamingException {
        String sql = "SELECT username, fullname, role FROM Student " +
                "WHERE username like ?";
        try (Connection connection = connectionHelper.getConnection();
             PreparedStatement preState = connection.prepareStatement(sql)) {
            preState.setString(1, username);
            try (ResultSet result = preState.executeQuery()) {
                String _username = "";
                String _fullname = "";
                boolean role = false;
                while (result.next()) {
                    _username = result.getString("username");
                    _fullname = result.getString("fullname");
                    role = result.getBoolean("role");
                }
                return of(new StudentDto()
                        .setFullname(_fullname)
                        .setRole(role)
                        .setUsername(_username));
            }
        }
    }

    @Override
    public Optional<StudentDto> save(StudentDto studentDto) throws SQLException, NamingException {
        Optional<StudentDto> record;
        String sql = "SELECT username, fullname, role FROM Student WHERE username = ?";
        try (Connection connection = connectionHelper.getConnection();
             PreparedStatement preState = connection.prepareStatement(sql)
        ) {
            preState.setString(1, studentDto.getUsername());
            try (ResultSet result = preState.executeQuery()) {
                record = result.next() ? update(studentDto, connection)
                                       : insert(studentDto, connection);
            }
        }
        return record;
    }

    private Optional<StudentDto> insert(StudentDto studentDto, Connection connection) throws SQLException {
        String sql = "INSERT INTO Student(username, fullname, role) VALUES(?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, studentDto.getUsername());
            preparedStatement.setString(2, studentDto.getFullname());
            preparedStatement.setString(3, String.valueOf(studentDto.isRole()));
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return of(studentDto);
    }

    private Optional<StudentDto> update(StudentDto studentDto, Connection connection) throws SQLException {
        String _sql = "UPDATE Student SET fullname = ?, role = ? WHERE username = ?";
        int result = 0;
        try {
            connectionHelper.autoCommit(connection, false);
            try (PreparedStatement preState = connection.prepareStatement(_sql)) {
                preState.setString(1, studentDto.getFullname());
                preState.setString(2, String.valueOf(studentDto.isRole()));
                preState.setString(3, studentDto.getUsername());
                result = preState.executeUpdate();
            }
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException(e);
        }
        connectionHelper.release(connection);
        return result > 0 ? of(studentDto) : empty();
    }


}
