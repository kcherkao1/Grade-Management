package com.example.miniprojgl.dao;

import com.example.miniprojgl.model.Teacher;
import java.util.List;

public interface TeacherDAO {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(int id);
    boolean addTeacher(Teacher teacher);
    boolean updateTeacher(Teacher teacher);
    boolean deleteTeacher(int id);
}
