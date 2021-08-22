package com.example.jdpc_in_best_practice.dbutil.config;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

//@UtilityClass
public class ConcreteDatasource implements DatasourceHelper {
    private final static ConcreteDatasource instance = new ConcreteDatasource();
    static final BasicDataSource datasource = new BasicDataSource();
    private ConcreteDatasource() {}
    static {
        datasource.setDriverClassName(DbConfiguration.DB_DRIVER);
        datasource.setUrl(DbConfiguration.CONNECTION_URL);
        datasource.setUsername(DbConfiguration.USERNAME);
        datasource.setPassword(DbConfiguration.PASSWORD);
        datasource.setMinIdle(DbConfiguration.DB_MIN_CONNECTIONS);
        datasource.setInitialSize(DbConfiguration.DB_MIN_CONNECTIONS);
        datasource.setMinIdle(DbConfiguration.DB_MAX_CONNECTIONS);
        datasource.setMaxOpenPreparedStatements(100);
    }

    public static ConcreteDatasource getInstance() {
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return datasource.getConnection();
    }

}
