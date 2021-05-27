package by.itClass.filters;

import by.itClass.constants.Constant;
import by.itClass.model.beans.User;
import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebFilter(filterName = "UserAuthorizationFilter",
        urlPatterns = {Constant.HOME_JSP, Constant.EVENT_JSP, Constant.NEW_EVENT_JSP,
                        Constant.ADD_EVENT_CONT, Constant.EVENT_LIST_CONT})
public class AuthorizationFilter implements Filter {
     public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
         HttpServletRequest request = (HttpServletRequest) req;
         HttpSession session = request.getSession();
         User user = (User) session.getAttribute(Constant.USER);

         if (Objects.isNull(user)) {
             HttpServletResponse response = (HttpServletResponse) resp;
             response.sendRedirect(request.getContextPath() + Constant.LOGIN_JSP);
             return;
         }

         chain.doFilter(req, resp);
    }

}
