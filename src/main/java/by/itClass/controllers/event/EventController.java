package by.itClass.controllers.event;

import by.itClass.constants.Constant;
import by.itClass.controllers.abstracts.AbstractController;
import by.itClass.model.beans.Event;
import by.itClass.model.exceptions.DAOException;
import by.itClass.model.exceptions.ServiceException;
import com.sun.org.apache.bcel.internal.Const;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EventController", urlPatterns = {Constant.EVENT_CONT})
public class EventController extends AbstractController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter(Constant.ID);

        try {
            Event event = eventService.get(id);
            request.setAttribute(Constant.EVENT, event);
            jump(request, response, Constant.EVENT_JSP);
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            jump(request, response, Constant.INDEX_JSP);
        }

    }
}
