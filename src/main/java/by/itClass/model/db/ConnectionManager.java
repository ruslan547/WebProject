package by.itClass.model.db;

import by.itClass.constants.Constant;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

public class ConnectionManager {
    private static Connection cn;
    private static Properties properties;

    static {
        try (InputStream in = Thread.currentThread()
                             .getContextClassLoader()
                             .getResourceAsStream(Constant.DB_PROPERTIES)) {
            properties = new Properties();
            properties.load(in);

            System.out.println(properties.getProperty(Constant.DB_DRIVER_PROPERTY_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            Class.forName(properties.getProperty(Constant.DB_DRIVER_PROPERTY_NAME));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (Objects.isNull(cn) || cn.isClosed()) {
            cn = DriverManager.getConnection(properties.getProperty(Constant.DB_URL_PROPERTY_NAME),
                                            properties.getProperty(Constant.DB_USER_PROPERTY_NAME),
                                            properties.getProperty(Constant.DB_PASSWORD_PROPERTY_NAME));
            System.out.println("Connection:" + cn);
        }
        return cn;
    }

    public static void closeConnection() {
        if (Objects.nonNull(cn)) {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(Statement st) {
        if (Objects.nonNull(st)) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (Objects.nonNull(rs)) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}