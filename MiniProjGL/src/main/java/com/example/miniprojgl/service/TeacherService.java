// src/main/java/com/example/miniprojgl/service/TeacherService.java
package com.example.miniprojgl.service;

import com.example.miniprojgl.model.Teacher;
import java.util.List;

// Inside TeacherService.java
public interface TeacherService {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(int id); // Add this line
    boolean addTeacher(Teacher teacher);
    boolean updateTeacher(Teacher teacher);
    boolean deleteTeacher(int id);
}


