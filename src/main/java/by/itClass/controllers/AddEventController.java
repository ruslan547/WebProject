package by.itClass.controllers;

import by.itClass.constants.Constant;
import by.itClass.model.beans.Event;
import by.itClass.model.beans.User;
import by.itClass.model.exceptions.DAOException;
import by.itClass.model.exceptions.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AddEventController", urlPatterns = {Constant.ADD_EVENT_CONT})
public class AddEventController extends AbstractController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter(Constant.TITLE);
        String desc = request.getParameter(Constant.DESC);
        String place = request.getParameter(Constant.PLACE);
        String date = request.getParameter(Constant.DATE);

        try {
            HttpSession session = request.getSession();
            Event event = new Event(title, desc, place, date);
            User user = (User) session.getAttribute(Constant.USER);
            eventService.add(event, user.getId());
            redirect(request, response, Constant.HOME_JSP);
        } catch (ServiceException | DAOException e) {
            e.printStackTrace();
            jumpMessage(request, response, Constant.NEW_EVENT_JSP, e.getMessage());
        }
    }
}
