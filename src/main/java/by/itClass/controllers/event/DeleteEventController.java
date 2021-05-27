package by.itClass.controllers.event;

import by.itClass.constants.Constant;
import by.itClass.controllers.abstracts.AbstractController;
import by.itClass.model.exceptions.DAOException;
import by.itClass.model.exceptions.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteEventController", urlPatterns = {Constant.DELETE_EVENT_CONT})
public class DeleteEventController extends AbstractController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues(Constant.ID);

        try {
            eventService.delete(ids);
            redirect(request, response, Constant.HOME_JSP);
        } catch (DAOException e) {
            e.printStackTrace();
            jumpMessage(request, response, Constant.HOME_JSP, e.getMessage());
        }
    }

}
