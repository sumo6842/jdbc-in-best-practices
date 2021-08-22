package com.example.jdpc_in_best_practice.dbutil;

import com.example.jdpc_in_best_practice.dbutil.config.ConcreteDatasource;
import com.example.jdpc_in_best_practice.dbutil.connectionhelper.SuppliedConnectionHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SuppliedConnectionHelperTest {
    private static final SuppliedConnectionHelper connectionHelper =
            new SuppliedConnectionHelper(ConcreteDatasource.getInstance());
//    private static Connection connection;
    @BeforeAll
    static void setUp() throws SQLException, NamingException {
//        connection = connectionHelper.getConnection();
    }


    @Test
    void testAutoCommit() throws SQLException, NamingException {
        try (Connection connection = connectionHelper.getConnection()) {
            assertTrue(connection.getAutoCommit());
        }
    }

    @Test
    void testStateAutoCommit() throws SQLException {
//        Connection connection;
        try(Connection connection = connectionHelper.getConnection()) {
            connectionHelper.autoCommit(connection, false);
            execute(connection);

            connectionHelper.release(connection);
            assertTrue(connection.getAutoCommit());
        } catch (SQLException | NamingException throwables) {
            throwables.printStackTrace();
        }
    }

    private void execute(Connection connection) {
        try {
            connectionHelper.autoCommit(connection, false);
            assertFalse(connection.getAutoCommit());
            connectionHelper.release(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}