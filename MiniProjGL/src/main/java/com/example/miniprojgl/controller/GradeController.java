package com.example.miniprojgl.controller;

import com.example.miniprojgl.model.Grade;
import com.example.miniprojgl.service.GradeService;
import com.example.miniprojgl.service.GradeServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet("/grades")
public class GradeController extends HttpServlet {

    private GradeService gradeService = new GradeServiceImpl();

    public GradeController() {
        // Initialize your GradeService here
        // This could be a direct instantiation or through dependency injection
        this.gradeService = new GradeServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteGrade(request, response);
                    break;
                case "generateReport":
                    generateReport(request, response);
                    break;
                default:
                    listGrades(request, response);
                    break;
            }
        } else {
            listGrades(request, response);
        }
    }

    private void generateReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String report = gradeService.generateGradeReportForStudent(studentId);

        response.setContentType("text/plain");
        response.setHeader("Content-Disposition", "attachment; filename=grade_report_student_" + studentId + ".txt");
        response.getOutputStream().write(report.getBytes(StandardCharsets.UTF_8));
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("insert".equals(action)) {
            addGrade(request, response);
        } else if ("update".equals(action)) {
            updateGrade(request, response);
        }
    }

    private void listGrades(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Grade> grades = gradeService.getAllGrades();
        request.setAttribute("grades", grades);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/grade-list.jsp");
        System.out.println("Grades: " + grades);

        dispatcher.forward(request, response);
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Grade existingGrade = gradeService.getGradeById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("grade-form.jsp");
        request.setAttribute("grade", existingGrade);
        dispatcher.forward(request, response);
    }

    private void addGrade(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int moduleId = Integer.parseInt(request.getParameter("moduleId"));
        float gradeValue = Float.parseFloat(request.getParameter("grade"));
        Grade newGrade = new Grade(studentId, moduleId, gradeValue);
        gradeService.addGrade(newGrade);
        response.sendRedirect("grades");
    }


    private void updateGrade(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int moduleId = Integer.parseInt(request.getParameter("moduleId"));
        float gradeValue = Float.parseFloat(request.getParameter("grade"));
        Grade grade = new Grade(id, studentId, moduleId, gradeValue);
        gradeService.updateGrade(grade);
        response.sendRedirect("grades");
    }

    private void deleteGrade(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        gradeService.deleteGrade(id);
        response.sendRedirect("grades");
    }


}
