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

@WebServlet("/admin/users/edit")
public class UserEditServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.getUserById(userId);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user-edit.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String role = request.getParameter("role"); // Get role from the request

        User userToUpdate = userDAO.getUserById(userId);
        if (userToUpdate != null) {
            userToUpdate.setUsername(username);
            userToUpdate.setEmail(email);
            userToUpdate.setRole(role); // Update role

            boolean updated = userDAO.updateUser(userToUpdate);
            if (updated) {
                // Redirect to user list or confirmation page
                response.sendRedirect(request.getContextPath() + "/admin/users");
            } else {
                // Handle update failure
                request.setAttribute("error", "Update failed");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user-edit.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            // Handle user not found
            response.sendRedirect(request.getContextPath() + "/admin/users?error=User not found");
        }
    }
}
