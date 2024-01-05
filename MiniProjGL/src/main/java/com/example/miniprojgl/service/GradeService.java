package com.example.miniprojgl.service;

import com.example.miniprojgl.model.Grade;
import java.util.List;

public interface GradeService {

    String generateGradeReportForStudent(int studentId);
    List<Grade> getGradesByStudent(int studentId);
    List<Grade> getGradesByModule(int moduleId);
    boolean addGrade(Grade grade);
    boolean updateGrade(Grade grade);
    boolean deleteGrade(int id);

    List<Grade> getAllGrades();

    Grade getGradeById(int id);
}
