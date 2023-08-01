package com.example.servlet;

import com.example.Warehouse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/users", loadOnStartup = 1)
public class GetUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("users", Warehouse.getInstance().getUsers());
            request.getRequestDispatcher("/jsp/users.jsp").forward(request, response);

        } catch(Exception e) {
            //System.out.println("Error: " + e.getCause());
        }
    }
}
