package by.itClass.filters;

import by.itClass.constants.Constant;
import com.sun.javafx.collections.MappingChange;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

@WebFilter(filterName = "ParamsFilter", urlPatterns = {Constant.DELETE_EVENT_CONT})
public class ParamsFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();

        if (params.values().size() == 0) {
            HttpServletResponse response = (HttpServletResponse) resp;
            response.sendRedirect(req.getServletContext().getContextPath() + Constant.HOME_JSP);
            return;
        }

        chain.doFilter(req, resp);
    }
}
