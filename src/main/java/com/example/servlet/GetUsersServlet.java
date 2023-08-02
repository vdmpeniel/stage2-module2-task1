package com.example.servlet;

import com.example.Warehouse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.logging.Logger;

@WebServlet(
        value="/users",
        initParams = {
                @WebInitParam(name = "USERS_JSP_PATH", value = "/jsp/users.jsp")
        }
)
public class GetUsersServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(GetUsersServlet.class.getName());
    private String usersJspPath;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        usersJspPath = config.getInitParameter("USERS_JSP_PATH");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setAttribute("users", Warehouse.getInstance().getUsers());
            RequestDispatcher dispatcher = request.getRequestDispatcher(usersJspPath);
            if (Objects.nonNull(dispatcher)) { dispatcher.forward(request, response); }

        } catch(Exception e){
            logger.info("Error: " + e.getCause());
        }
    }
}
