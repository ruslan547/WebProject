package by.itClass.model.dao.interfaces;

import by.itClass.model.beans.Event;
import by.itClass.model.enums.SectionMenu;

import java.util.List;

public interface EventDAO {
    List<Event> getList(SectionMenu section);
}
