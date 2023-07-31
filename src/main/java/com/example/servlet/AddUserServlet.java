package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(value="/add", loadOnStartup = 1)
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // forward to add.jsp
        request.getRequestDispatcher("/jsp/add.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // forward to add.jsp
        try {
            if (Objects.nonNull(request)) {
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                if (firstName != null && lastName != null) {
                    User user = new User(firstName, lastName);
                    request.setAttribute("user", user);
                    Warehouse.getInstance().addUser(user);
                }
                request.getRequestDispatcher("/jsp/add.jsp").forward(request, response);
            }

        } catch(Exception e) {
            System.out.println("Error: " + e.getCause());
        }

    }
}
