package com.example.jdpc_in_best_practice.dbutil.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//@UtilityClass
public class TomcatDatasource implements DatasourceHelper {
    private static final TomcatDatasource instance = new TomcatDatasource();

    private TomcatDatasource() {}

    public static TomcatDatasource getInstance() {
        return instance;
    }

    public Connection getConnection() throws SQLException {
        try {
            DataSource data = getDataSource();
            return data.getConnection();
        } catch (NamingException e) {
            throw new RuntimeException("Data source error: " + e.getMessage());
        }
    }

    private DataSource getDataSource() throws NamingException {
        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:/comp/env");
        return (DataSource) envContext.lookup("jdbc/Student");
    }
}
