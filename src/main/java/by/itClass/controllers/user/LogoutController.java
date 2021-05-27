package by.itClass.controllers.user;

import by.itClass.constants.Constant;
import by.itClass.controllers.abstracts.AbstractController;
import by.itClass.model.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "LogoutController", urlPatterns = {Constant.LOGOUT_CONT})
public class LogoutController extends AbstractController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constant.USER);

        if (Objects.nonNull(user)) {
            session.invalidate();
        }
        redirect(request, response, Constant.INDEX_JSP);
    }
}
