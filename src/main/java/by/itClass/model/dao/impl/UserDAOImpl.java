package by.itClass.model.dao.impl;

import by.itClass.constants.Constant;
import by.itClass.constants.Messages;
import by.itClass.constants.SQLRequest;
import by.itClass.model.beans.User;
import by.itClass.model.dao.interfaces.UserDAO;
import by.itClass.model.db.ConnectionManager;
import by.itClass.model.exceptions.DAOException;

import java.sql.*;

public class UserDAOImpl implements UserDAO {
    @Override
    public void save(User user, String password) throws DAOException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = ConnectionManager.getConnection();
            pst = cn.prepareStatement(SQLRequest.SAVE_USER, Statement.RETURN_GENERATED_KEYS);

            if (!isFoundLogin(user.getLogin())) {
                pst.setString(1, user.getLogin());
                pst.setString(2, password);
                pst.setString(3, user.getName());
                pst.setString(4, user.getSurname());
                pst.setInt(5, user.getAge());
                pst.setString(6, user.getEmail());
                pst.executeUpdate();
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                   int id = rs.getInt(1);
                   user.setId(id);
                }
            } else {
                throw new DAOException(Messages.USER_IS_FOUND);
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            ConnectionManager.closeStatement(pst);
            ConnectionManager.closeConnection();
        }
    }

    private synchronized boolean isFoundLogin(String login) throws DAOException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean isFound = false;

        try {
            cn = ConnectionManager.getConnection();
            pst = cn.prepareStatement(SQLRequest.FOUND_LOGIN);
            pst.setString(1, login);
            rs = pst.executeQuery();
            isFound = rs.next();

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            ConnectionManager.closeResultSet(rs);
            ConnectionManager.closeStatement(pst);
        }

        return isFound;
    }

    @Override
    public User get(String login, String password) throws DAOException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        User user = null;

        try {
            if (isFoundLogin(login)) {
                cn = ConnectionManager.getConnection();
                pst = cn.prepareStatement(SQLRequest.GET_USER);
                pst.setString(1, login);
                pst.setString(2, password);
                rs = pst.executeQuery();

                if (rs.next()) {
                    int id = rs.getInt(Constant.ID);
                    String name = rs.getString(Constant.NAME);
                    String surname = rs.getString(Constant.NAME);
                    int age = rs.getInt(Constant.AGE);
                    String email = rs.getString(Constant.EMAIL);

                    user = new User(id, login, name, surname, age, email);

                }
            } else {
                throw new DAOException(Messages.USER_NOT_FOUND);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            ConnectionManager.closeResultSet(rs);
            ConnectionManager.closeStatement(pst);
            ConnectionManager.closeConnection();
        }

        return user;
    }
}
