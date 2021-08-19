package com.example.jdpc_in_best_practice.dbutil.config;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DbConfiguration {
    String HOST_NAME = "localhost";
    String DB_NAME = "Student";
    String DB_POST = "1433";
    String USERNAME = "sa";
    String PASSWORD = "Linhduc13";
    String DB_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    int DB_MIN_CONNECTIONS = 2;
    int DB_MAX_CONNECTIONS = 4;
    String CONNECTION_URL = "jdbc:sqlserver://localhost;database=Student";
}
