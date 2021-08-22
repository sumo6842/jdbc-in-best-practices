package com.example.jdpc_in_best_practice.dbutil.connectionhelper;

import lombok.experimental.UtilityClass;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionHelper {
    void autoCommit(Connection connection, boolean needsAutoCommit)  throws SQLException;

    Connection getConnection() throws SQLException, NamingException;

    void release(Connection connection) throws SQLException;
}
