package by.itClass.model.db;

import java.sql.Connection;

public class ConnectionManager {
    private static Connection cn;

    public static Connection getConnection() {
        return cn;
    }
}
