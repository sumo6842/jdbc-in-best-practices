package com.example.jdpc_in_best_practice.dbutil;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatasourceHelper {
    Connection getConnection() throws SQLException;
}
