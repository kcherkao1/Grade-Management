package com.example.miniprojgl.service;

import com.example.miniprojgl.dao.GradeDAO;
import com.example.miniprojgl.dao.GradeDAOImpl;
import com.example.miniprojgl.model.Grade;
import java.util.List;

public class GradeServiceImpl implements GradeService {
    private GradeDAO gradeDAO = new GradeDAOImpl();

    @Override
    public String generateGradeReportForStudent(int studentId) {
        List<Grade> grades = gradeDAO.getGradesByStudent(studentId);
        StringBuilder report = new StringBuilder();

        report.append("Grade Report for Student ID: ").append(studentId).append("\n\n");
        for (Grade grade : grades) {
            report.append("Module ID: ").append(grade.getModuleId())
                    .append(", Grade: ").append(grade.getGrade()).append("\n");
        }

        if (grades.isEmpty()) {
            report.append("No grades recorded for this student.");
        }

        return report.toString();
    }

    @Override
    public List<Grade> getGradesByStudent(int studentId) {
        return gradeDAO.getGradesByStudent(studentId);
    }

    @Override
    public List<Grade> getGradesByModule(int moduleId) {
        return gradeDAO.getGradesByModule(moduleId);
    }

    @Override
    public boolean addGrade(Grade grade) {
        return gradeDAO.addGrade(grade);
    }

    @Override
    public boolean updateGrade(Grade grade) {
        return gradeDAO.updateGrade(grade);
    }

    @Override
    public boolean deleteGrade(int id) {
        return gradeDAO.deleteGrade(id);
    }

    @Override
    public List<Grade> getAllGrades() {
        return gradeDAO.getAllGrades();
    }


    @Override
    public Grade getGradeById(int id) {
        return null;
    }
}
