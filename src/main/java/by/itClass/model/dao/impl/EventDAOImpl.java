package by.itClass.model.dao.impl;

import by.itClass.constants.Constant;
import by.itClass.model.beans.Event;
import by.itClass.model.dao.interfaces.EventDAO;
import by.itClass.model.db.ConnectionManager;
import by.itClass.model.enums.SectionMenu;
import by.itClass.model.exceptions.DAOException;
import com.sun.org.apache.bcel.internal.Const;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAOImpl implements EventDAO {
    @Override
    public List<Event> getList(SectionMenu section) throws DAOException {
        List<Event> events = null;

        try (Connection cn = ConnectionManager.getConnection();
            PreparedStatement pst = cn.prepareStatement(section.getSql())
        ) {
            events = getList(pst);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return events;
    }

    @Override
    public List<Event> getList(int idUser) throws DAOException {
        SectionMenu section = SectionMenu.HOME;
        List<Event> events = null;

        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement pst = cn.prepareStatement(section.getSql())) {
            pst.setInt(1, idUser);
            events = getList(pst);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(e);
        }

        return events;
    }

    private List<Event> getList(PreparedStatement pst) throws SQLException {
       List<Event> events = new ArrayList<>();
       Connection cn = ConnectionManager.getConnection();

        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt(Constant.ID);
                String title = rs.getString(Constant.TITLE);
                String desc = rs.getString(Constant.DESC);
                String place = rs.getString(Constant.PLACE);
                Date date = rs.getDate(Constant.DATE);
                String author = rs.getString(Constant.AUTHOR);

                events.add(new Event(id, title, desc, place, date, author));
            }
        }

        return events;
    }
}
