package by.itClass.model.services.impl;

import by.itClass.model.beans.User;
import by.itClass.model.dao.interfaces.UserDAO;
import by.itClass.model.dao.impl.UserDAOImpl;
import by.itClass.model.exceptions.DAOException;
import by.itClass.model.services.interfaces.UserService;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl() {
        userDAO = new UserDAOImpl();
    }

    @Override
    public void save(User user, String password) throws DAOException {
        userDAO.save(user, password);
    }

    @Override
    public User get(String login, String password) throws DAOException {
        return userDAO.get(login, password);
    }
}
