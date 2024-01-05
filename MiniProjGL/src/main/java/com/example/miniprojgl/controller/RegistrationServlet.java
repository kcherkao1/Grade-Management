package com.example.miniprojgl.controller;

import com.example.miniprojgl.dao.UserDAO;
import com.example.miniprojgl.dao.UserDAOImpl;
import com.example.miniprojgl.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password); // Hash the password in a real application
        newUser.setEmail(email);
        newUser.setRole(role);

        boolean isRegistered = userDAO.insertUser(newUser);
        if (isRegistered) {
            response.sendRedirect(request.getContextPath() + "/login"); // Redirect to login page
        } else {
            request.setAttribute("message", "Registration failed");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }
}
