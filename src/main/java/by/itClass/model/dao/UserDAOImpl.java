package by.itClass.model.dao;

import by.itClass.model.beans.User;

import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(User user, String password) throws SQLException {
        return false;
    }
}
