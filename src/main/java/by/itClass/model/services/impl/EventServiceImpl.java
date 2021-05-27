package by.itClass.model.services.impl;

import by.itClass.model.beans.Event;
import by.itClass.model.dao.impl.EventDAOImpl;
import by.itClass.model.dao.interfaces.EventDAO;
import by.itClass.model.enums.SectionMenu;
import by.itClass.model.exceptions.DAOException;
import by.itClass.model.exceptions.ServiceException;
import by.itClass.model.services.interfaces.EventService;

import java.util.Arrays;
import java.util.List;

public class EventServiceImpl implements EventService {
    private EventDAO eventDAO;

    public EventServiceImpl() {
        eventDAO = new EventDAOImpl();
    }

    @Override
    public List<Event> getList(SectionMenu section) throws DAOException {
        return eventDAO.getList(section);
    }

    @Override
    public List<Event> getList(int idUser) throws DAOException {
        return eventDAO.getList(idUser);
    }

    @Override
    public void add(Event event, int idUser) throws DAOException {
        eventDAO.add(event, idUser);
    }

    @Override
    public void delete(String[] ids) throws DAOException {

        eventDAO.delete(ids);
    }

    @Override
    public Event get(String id) throws DAOException, ServiceException {

        try {
            int idEvent = Integer.parseInt(id);
            return eventDAO.get(idEvent);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }



    }
}
