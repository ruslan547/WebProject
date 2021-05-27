package by.itClass.model.services.interfaces;

import by.itClass.model.beans.Event;
import by.itClass.model.enums.SectionMenu;
import by.itClass.model.exceptions.DAOException;
import by.itClass.model.exceptions.ServiceException;

import java.util.List;

public interface EventService {
    List<Event> getList(SectionMenu section) throws DAOException;
    List<Event> getList(int idUser) throws DAOException;
    void add(Event event, int id) throws DAOException;
    void delete(String[] ids) throws DAOException;
    Event get(String id) throws DAOException, ServiceException;
}
