package by.itClass.controllers.event;

import by.itClass.constants.Constant;
import by.itClass.controllers.abstracts.AbstractController;
import by.itClass.model.beans.Event;
import by.itClass.model.beans.User;
import by.itClass.model.exceptions.DAOException;
import by.itClass.model.exceptions.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

@WebServlet(name = "AddEventController", urlPatterns = {Constant.ADD_EVENT_CONT})
public class AddEventController extends AbstractController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter(Constant.TITLE);
        String descr = request.getParameter(Constant.DESCR);
        String place = request.getParameter(Constant.PLACE);
        String date = request.getParameter(Constant.DATE);


         String[] pr_titles = request.getParameterValues(Constant.PR_TITLE);
         String[] pr_times = request.getParameterValues(Constant.PR_TIME);

        try {
            HttpSession session = request.getSession();
            Event event = new Event(title, descr, place, date);
            System.out.println(Arrays.toString(pr_times));
            event.addPrograms(pr_titles, pr_times);
            User user = (User) session.getAttribute(Constant.USER);
            eventService.add(event, user.getId());
            redirect(request, response, Constant.HOME_JSP);
        } catch (ServiceException | DAOException e) {
            e.printStackTrace();
            jumpMessage(request, response, Constant.NEW_EVENT_JSP, e.getMessage());
        }
    }

}
