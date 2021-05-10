package by.itClass.model.dao.impl;

import by.itClass.constants.Constant;
import by.itClass.model.beans.Event;
import by.itClass.model.dao.interfaces.EventDAO;
import by.itClass.model.db.ConnectionManager;
import by.itClass.model.enums.SectionMenu;
import com.sun.org.apache.bcel.internal.Const;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAOImpl implements EventDAO {
    @Override
    public List<Event> getList(SectionMenu section) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Event> events = new ArrayList<>();
        String sql = section.getSql();

        try {
            cn = ConnectionManager.getConnection();
            pst = cn.prepareStatement(sql);
            pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(Constant.ID);
                String title = rs.getString(Constant.TITLE);
                String desc = rs.getString(Constant.DESC);
                String place = rs.getString(Constant.PLACE);
                Date date = rs.getDate(Constant.DATE);
                String author = rs.getString(Constant.AUTHOR);

                events.add(new Event(id, title, desc, place, date, author));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // TO DO
        }


        return events;
    }
}
