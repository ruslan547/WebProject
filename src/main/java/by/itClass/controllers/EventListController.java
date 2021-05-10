package by.itClass.controllers;

import by.itClass.constants.Constant;
import by.itClass.model.beans.Event;
import by.itClass.model.enums.EnumManager;
import by.itClass.model.enums.SectionMenu;
import by.itClass.model.exceptions.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EventListController", urlPatterns = {Constant.EVENT_LIST_CONT})
public class EventListController extends AbstractController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sect = request.getParameter(Constant.SECTION);

        try {
            SectionMenu section = EnumManager.getKindSectionMenu(sect);
            List<Event> events = eventService.getList(section);

        } catch (ServiceException e) {
            jumpMessage(request, response, Constant.INDEX_JSP, e.getMessage());
            e.printStackTrace();
        }
    }
}
