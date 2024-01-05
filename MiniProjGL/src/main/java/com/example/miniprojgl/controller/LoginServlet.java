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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to the login page
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Authenticate user using database logic
        User user = userDAO.authenticateUser(username, password);

        if (user != null) {
            request.getSession().setAttribute("user", user); // User is logged in

            // Redirect based on user role
            if ("admin".equalsIgnoreCase(user.getRole())) {
                response.sendRedirect("adminDashboard.jsp"); // Redirect to the admin dashboard
            } else {
                response.sendRedirect("userDashboard.jsp"); // Redirect to the user dashboard
            }
        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response); // Show login page again with an error
        }
    }
}
