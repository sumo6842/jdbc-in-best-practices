package com.example.jdpc_in_best_practice.dbutil;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

public class SuppliedConnectionHelper implements ConnectionHelper {
    private boolean toggleAutoCommit;
    private final DatasourceHelper datasource;

    public SuppliedConnectionHelper(DatasourceHelper helper) {
        this.datasource = helper;
    }

    @Override
    public void release(Connection connection) throws SQLException {
        if (!toggleAutoCommit) {
            toggleAutoCommit = true;
            connection.commit();
            connection.setAutoCommit(toggleAutoCommit);
        }
    }

    @Override
    public Connection getConnection() throws SQLException, NamingException {
        Connection connection = datasource.getConnection();
        toggleAutoCommit = connection.getAutoCommit();
        return connection;
    }

    @Override
    public void autoCommit(Connection connection, boolean needsAutoCommit) throws SQLException {
        toggleAutoCommit = connection.getAutoCommit() && !needsAutoCommit;
        if (toggleAutoCommit) {
            toggleAutoCommit = false;
            connection.setAutoCommit(false);
        }
    }
}
