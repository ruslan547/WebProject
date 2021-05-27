package by.itClass.controllers.abstracts;

import by.itClass.constants.Constant;
import by.itClass.model.services.impl.EventServiceImpl;
import by.itClass.model.services.interfaces.EventService;
import by.itClass.model.services.interfaces.UserService;
import by.itClass.model.services.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AbstractController")
public abstract class AbstractController extends HttpServlet {
    protected UserService userService;
    protected EventService eventService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = new UserServiceImpl();
        eventService = new EventServiceImpl();
    }

    protected void jump(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    protected void jumpMessage(HttpServletRequest request, HttpServletResponse response, String url, String message) throws ServletException, IOException {
        request.setAttribute(Constant.MESSAGE, message);
        jump(request, response, url);
    }

    protected void redirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
        //Метод getContextPath() возвращает название контекста
        response.sendRedirect(request.getContextPath() + url);// web/url
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
