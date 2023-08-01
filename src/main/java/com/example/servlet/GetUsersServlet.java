package com.example.servlet;

import com.example.Warehouse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(value="/users")
public class GetUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setAttribute("users", Warehouse.getInstance().getUsers());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/users.jsp");
            if (Objects.nonNull(dispatcher)) { dispatcher.forward(request, response); }
        } catch(Exception e){}
    }
}
