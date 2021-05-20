package by.itClass.model.services.interfaces;

import by.itClass.model.beans.Event;
import by.itClass.model.enums.SectionMenu;
import by.itClass.model.exceptions.DAOException;

import java.util.List;

public interface EventService {
    List<Event> getList(SectionMenu section) throws DAOException;
    List<Event> getList(int idUser) throws DAOException;
    void add(Event event, int idUser) throws DAOException;
}
