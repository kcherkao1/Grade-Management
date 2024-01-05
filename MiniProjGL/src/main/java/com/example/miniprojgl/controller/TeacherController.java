package com.example.miniprojgl.controller;

import com.example.miniprojgl.model.Teacher;
import com.example.miniprojgl.model.User;
import com.example.miniprojgl.service.TeacherService;
import com.example.miniprojgl.service.TeacherServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TeacherController", urlPatterns = {"/teachers"})
public class TeacherController extends HttpServlet {

    private TeacherService teacherService = new TeacherServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String action = request.getParameter("action");
        if (user != null && "admin".equalsIgnoreCase(user.getRole())) {
            if (action != null && action.equals("editForm")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Teacher teacher = teacherService.getTeacherById(id); // Implement this method in service
                request.setAttribute("teacher", teacher);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/edit-teacher.jsp");
                dispatcher.forward(request, response);
            } else {
                List<Teacher> teachers = teacherService.getAllTeachers();
                request.setAttribute("teachers", teachers);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/teacher-list.jsp");
                dispatcher.forward(request, response);
            }
            if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                teacherService.deleteTeacher(id);
                response.sendRedirect("teachers");
            }
        } else {
            // Redirect to login or access denied page
            response.sendRedirect("/MiniProjGL_war/accessDenied.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            addTeacher(request, response);
        } else if ("edit".equals(action)) {
            editTeacher(request, response);
        } else if ("delete".equals(action)) {
            deleteTeacher(request, response);
        }
    }

    private void addTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String specialty = request.getParameter("specialty");

        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty() && specialty != null && !specialty.isEmpty()) {
            Teacher newTeacher = new Teacher(0, firstName, lastName, specialty);
            boolean success = teacherService.addTeacher(newTeacher);

            if (success) {
                response.sendRedirect("teachers");
            } else {
                // Handle failure, perhaps set an error message and redirect to an error page or back to the form
                response.sendRedirect("teachers?error=Unable to add teacher");
            }
        } else {
            // Handle invalid input
            response.sendRedirect("teachers?error=Invalid input data");
        }
    }

    private void editTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String specialty = request.getParameter("specialty");

        Teacher teacherToUpdate = new Teacher(id, firstName, lastName, specialty);
        boolean success = teacherService.updateTeacher(teacherToUpdate); // Implement this method in service

        if (success) {
            response.sendRedirect("teachers");
        } else {
            response.sendRedirect("teachers?error=Unable to update teacher");
        }
    }

    private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean success = teacherService.deleteTeacher(id); // Implement this method in service

        if (success) {
            response.sendRedirect("teachers");
        } else {
            response.sendRedirect("teachers?error=Unable to delete teacher");
        }
    }
}
