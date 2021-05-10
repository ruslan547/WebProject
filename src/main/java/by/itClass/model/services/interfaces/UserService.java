package by.itClass.model.services.interfaces;

import by.itClass.model.beans.User;
import by.itClass.model.exceptions.DAOException;

public interface UserService {
    void save(User user, String password) throws DAOException;
    User get(String login, String password) throws DAOException;
}
