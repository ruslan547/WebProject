package by.itClass.model.dao;

import by.itClass.model.beans.User;

import java.sql.SQLException;

public interface UserDAO {
    boolean save(User user, String password) throws SQLException;
}
