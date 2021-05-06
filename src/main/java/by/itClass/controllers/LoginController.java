package by.itClass.controllers;

import by.itClass.constants.Constant;
import by.itClass.model.beans.User;
import by.itClass.model.exceptions.DAOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "login", urlPatterns = {Constant.LOGIN_CONT})
public class LoginController extends AbstractController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, String> requestData = new HashMap<>();

        requestData.put(Constant.LOGIN, request.getParameter(Constant.LOGIN));
        requestData.put(Constant.PASSWORD, request.getParameter(Constant.PASSWORD));


        try {
            User user = userService.get(requestData.get(Constant.LOGIN), requestData.get(Constant.PASSWORD));
            request.setAttribute(Constant.USER, user);
            jump(request, response, Constant.HOME_JSP);
        } catch (DAOException e) {
            jumpMessage(request, response, e.getMessage(), Constant.LOGIN_JSP);
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
