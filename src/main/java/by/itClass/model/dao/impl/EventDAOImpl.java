package by.itClass.model.dao.impl;

import by.itClass.constants.Constant;
import by.itClass.constants.SQLRequest;
import by.itClass.model.beans.Event;
import by.itClass.model.beans.Program;
import by.itClass.model.dao.interfaces.EventDAO;
import by.itClass.model.db.ConnectionManager;
import by.itClass.model.enums.SectionMenu;
import by.itClass.model.exceptions.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAOImpl implements EventDAO {
    @Override
    public List<Event> getList(SectionMenu section) throws DAOException {
        List<Event> events = null;
        try (Connection cn = ConnectionManager.getConnection();
                PreparedStatement pst = cn.prepareStatement(section.getSql())) {
            events = getList(pst);
            return events;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(e);
        }

    }

    @Override
    public List<Event> getList(int idUser) throws DAOException {
        SectionMenu section = SectionMenu.HOME;
        List<Event> events = null;
        try (Connection cn = ConnectionManager.getConnection();
        PreparedStatement pst = cn.prepareStatement(section.getSql())) {
            pst.setInt(1, idUser);
            events = getList(pst);
            return events;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(e);
        }
    }

    @Override
    public void add(Event event, int idUser) throws DAOException {
        ResultSet rs = null;
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement pst = cn.prepareStatement(SQLRequest.ADD_EVENT, Statement.RETURN_GENERATED_KEYS);
           ) {
            pst.setInt(1, idUser);
            pst.setString(2, event.getTitle());
            pst.setString(3, event.getDescr());
            pst.setString(4, event.getPlace());
            pst.setDate(5, event.getDate());

            if(pst.executeUpdate() > 0) {
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    event.setId(id);
                    addPrograms(event);
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(e);
        } finally {
            ConnectionManager.closeResultSet(rs);
        }
    }

    @Override
    public void delete(String[] ids) throws DAOException {
        try (Connection cn = ConnectionManager.getConnection();
        PreparedStatement pst = cn.prepareStatement(SQLRequest.DELETE_EVENT)) {
            for (String id: ids) {
                int intID = Integer.parseInt(id);
                pst.setInt(1, intID);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(e);
        }
    }

    @Override
    public Event get(int id) throws DAOException {
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement pst = cn.prepareStatement(SectionMenu.BY_ID.getSql())) {
            pst.setInt(1, id);
            return getList(pst).get(0);
        } catch (SQLException e) {
           e.printStackTrace();
            throw new DAOException(e);
        }
    }

    private List<Event> getList(PreparedStatement pst) throws SQLException {
        List<Event> events = new ArrayList<>();

        try (ResultSet rs = pst.executeQuery()){
            while (rs.next()) {
                int id = rs.getInt(Constant.ID);
                String title = rs.getString(Constant.TITLE);
                String descr = rs.getString(Constant.DESCR);
                String place = rs.getString(Constant.PLACE);
                Date date = rs.getDate(Constant.DATE);
                String author = rs.getString(Constant.AUTHOR);
                Event event = new Event(id, title, descr, place, date, author);
                events.add(event);
            }
        }

        //TO DO REPLACE FORREACH
        for (Event event : events) {
            List<Program> programs = getPrograms(event.getId());
            event.setPrograms(programs);
        }
        return events;
    }

    private void addPrograms(Event event) throws SQLException {
        try (Connection cn = ConnectionManager.getConnection();
            PreparedStatement pst = cn.prepareStatement(SQLRequest.ADD_PROGRAM)){
            pst.setInt(1, event.getId());
            for (Program program : event.getPrograms()) {
                pst.setString(2, program.getTitle());
                pst.setTime(3, program.getTime());
                pst.executeUpdate();
            }
        }
    }

    public List<Program> getPrograms(int idEvent) throws SQLException {
        ResultSet rs = null;
        List<Program> programs = new ArrayList<>();

        try (Connection cn = ConnectionManager.getConnection();
        PreparedStatement pst = cn.prepareStatement(SQLRequest.GET_PROGRAMS)) {
            pst.setInt(1, idEvent);
            rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(Constant.ID);
                String title = rs.getString(Constant.TITLE);
                Time time = rs.getTime(Constant.TIME);
                programs.add(new Program(id, title, time));
            }
        } finally {
            ConnectionManager.closeResultSet(rs);
        }
        return programs;
    }
}
