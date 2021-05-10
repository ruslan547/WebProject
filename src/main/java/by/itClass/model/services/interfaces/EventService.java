package by.itClass.model.services.interfaces;

import by.itClass.model.beans.Event;
import by.itClass.model.enums.SectionMenu;

import java.util.List;

public interface EventService {
    List<Event> getList(SectionMenu section);
}
