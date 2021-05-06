package by.itClass.controllers;

import by.itClass.constants.Constant;
import by.itClass.model.services.UserService;
import by.itClass.model.services.UserServiceImpl;

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

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = new UserServiceImpl();
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
        //method getContextPath return the name of the context
        response.sendRedirect(request.getContextPath() + url); // web/url
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
