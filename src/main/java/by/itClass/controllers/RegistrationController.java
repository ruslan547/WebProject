package by.itClass.controllers;

import by.itClass.constants.Constant;
import by.itClass.model.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "registration", urlPatterns = {"/regist"})
public class RegistrationController extends AbstractController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(Constant.LOGIN);
        String password = request.getParameter(Constant.PASSWORD);
        String name = request.getParameter(Constant.NAME);
        String surname = request.getParameter(Constant.SURNAME);
        String age = request.getParameter(Constant.AGE);
        String email = request.getParameter(Constant.EMAIL);

        User user = new User(login, name, surname, age, email);

        userService.save(user, password);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
