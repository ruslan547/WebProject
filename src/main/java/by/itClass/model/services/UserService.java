package by.itClass.model.services;

import by.itClass.model.beans.User;
import by.itClass.model.exceptions.DAOException;

public interface UserService {
    void save(User user, String password) throws DAOException;
}
