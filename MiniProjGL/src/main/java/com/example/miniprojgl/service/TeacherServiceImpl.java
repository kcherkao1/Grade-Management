package com.example.miniprojgl.service;

import com.example.miniprojgl.dao.TeacherDAO;
import com.example.miniprojgl.dao.TeacherDAOImpl;
import com.example.miniprojgl.model.Teacher;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private TeacherDAO teacherDAO = new TeacherDAOImpl();

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDAO.getAllTeachers();
    }

    @Override
    public Teacher getTeacherById(int id) {
        return teacherDAO.getTeacherById(id); // Ensure this method is implemented in TeacherDAOImpl
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        return teacherDAO.addTeacher(teacher);
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return teacherDAO.updateTeacher(teacher);
    }

    @Override
    public boolean deleteTeacher(int id) {
        return teacherDAO.deleteTeacher(id);
    }

    // ... other service method implementations
}
