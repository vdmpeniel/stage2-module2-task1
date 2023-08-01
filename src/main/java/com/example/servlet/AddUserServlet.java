package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(value="/add")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            if (Objects.nonNull(request)) {
                // forward to add.jsp
                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/add.jsp");
                if (Objects.nonNull(dispatcher)) {
                    dispatcher.forward(request, response);
                }
            }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Objects.nonNull(request)) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            if (firstName != null && lastName != null) {
                User user = new User(firstName, lastName);
                request.setAttribute("user", user);
                Warehouse.getInstance().addUser(user);
            }

            // forward to add.jsp
            doGet(request, response);
        }
    }
}
