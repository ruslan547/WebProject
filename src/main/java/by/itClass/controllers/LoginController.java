package by.itClass.controllers;

import by.itClass.constants.Constant;
import by.itClass.constants.Messages;
import by.itClass.model.beans.User;
import by.itClass.model.exceptions.DAOException;
import sun.plugin2.message.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

@WebServlet(name = "login", urlPatterns = {Constant.LOGIN_CONT})
public class LoginController extends AbstractController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(Constant.LOGIN);
        String password = request.getParameter(Constant.PASSWORD);


        try {
            User user = userService.get(login, password);
            if (Objects.nonNull(user)) {
                HttpSession session = request.getSession();
                session.setAttribute(Constant.USER, user);
                jump(request, response, Constant.HOME_JSP);
            } else {
                jumpMessage(request, response, Constant.LOGIN_JSP, Messages.USER_NOT_FOUND);
            }
        } catch (DAOException e) {
            jumpMessage(request, response, Constant.LOGIN_JSP, e.getMessage());
            e.printStackTrace();
        }


    }
}
