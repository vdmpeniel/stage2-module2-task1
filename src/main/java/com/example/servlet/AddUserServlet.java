package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Objects;

@WebServlet(value="/add", loadOnStartup = 1)
public class AddUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ServletException {

        // forward to add.jsp
        request.getRequestDispatcher("/jsp/add.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // forward to add.jsp
        if (Objects.nonNull(request)) {
            User user = new User(request.getParameter("firstName"), request.getParameter("lastName"));

            if (Objects.nonNull(user)) {
                request.setAttribute("user", user);
                Warehouse.getInstance().addUser(user);
            }
            request.getRequestDispatcher("/jsp/add.jsp").forward(request, response);
        }
    }
}
