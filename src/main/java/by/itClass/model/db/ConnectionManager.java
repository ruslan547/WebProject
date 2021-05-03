package by.itClass.model.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionManager {
    private static Connection cn;

    public static Connection getConnection() {
        return cn;
    }

    public static void closeConnection() {

    }

    public static void closeStatement(Statement st) {

    }

    public static void closeResultSet(ResultSet rs) {

    }
}
