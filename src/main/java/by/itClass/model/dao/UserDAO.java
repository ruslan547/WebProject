package by.itClass.model.dao;

import by.itClass.model.beans.User;
import by.itClass.model.exceptions.DAOException;

import java.sql.SQLException;

public interface UserDAO {
    void save(User user, String password) throws DAOException;
    User get(String login, String password) throws DAOException;
}
