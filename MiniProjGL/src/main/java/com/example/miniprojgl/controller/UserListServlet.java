package com.example.miniprojgl.controller;

import com.example.miniprojgl.dao.UserDAO;
import com.example.miniprojgl.dao.UserDAOImpl;
import com.example.miniprojgl.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/users")
public class UserListServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAOImpl(); // Assume you have a UserDAO for database operations

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userDAO.getAllUsers();
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user-list.jsp");
        dispatcher.forward(request, response);
    }
}
