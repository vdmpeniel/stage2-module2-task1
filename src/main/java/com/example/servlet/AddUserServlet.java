package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

@WebServlet(
        value="/add",
        initParams = {
            @WebInitParam(name = "ADD_JSP_PATH", value = "/jsp/add.jsp")
        }
)
public class AddUserServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(AddUserServlet.class.getName());
    private String addJspPath;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        addJspPath = config.getInitParameter("ADD_JSP_PATH");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            // forward to add.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher(addJspPath);
            dispatcher.forward(request, response);

        } catch(Exception e) {
            logger.info("Error: " + e.getCause());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            if (firstName != null && lastName != null) {
                User user = new User(firstName, lastName);
                request.setAttribute("user", user);
                Warehouse.getInstance().addUser(user);
            }

            // forward to add.jsp
            doGet(request, response);

        } catch(Exception e) {
            logger.info("Error: " + e.getCause());
        }
    }
}
