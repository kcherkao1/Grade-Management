// src/main/java/com/example/miniprojl/dao/TeacherDAOImpl.java
package com.example.miniprojgl.dao;

import com.example.miniprojgl.model.Teacher;
import com.example.miniprojgl.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAOImpl implements TeacherDAO {

    private Connection connection = DatabaseConnection.getConnection();

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        String sql = "SELECT id, firstName, lastName, specialty FROM teachers";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getInt("id"));
                teacher.setFirstName(resultSet.getString("firstName"));
                teacher.setLastName(resultSet.getString("lastName"));
                teacher.setSpecialty(resultSet.getString("specialty"));
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this instead
            // Handle exception, for example, by logging or rethrowing a custom exception
        }
        return teachers;
    }

    @Override
    public Teacher getTeacherById(int id) {
        Teacher teacher = null;
        String sql = "SELECT id, firstName, lastName, specialty FROM teachers WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    teacher = new Teacher(
                            resultSet.getInt("id"),
                            resultSet.getString("firstName"),
                            resultSet.getString("lastName"),
                            resultSet.getString("specialty")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider proper logging
        }
        return teacher;
    }

    // Inside TeacherDAOImpl.java
    @Override
    public boolean addTeacher(Teacher teacher) {
        String sql = "INSERT INTO teachers (firstName, lastName, specialty) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, teacher.getFirstName());
            statement.setString(2, teacher.getLastName());
            statement.setString(3, teacher.getSpecialty());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    // Inside TeacherDAOImpl.java
    @Override
    public boolean updateTeacher(Teacher teacher) {
        String sql = "UPDATE teachers SET firstName = ?, lastName = ?, specialty = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, teacher.getFirstName());
            statement.setString(2, teacher.getLastName());
            statement.setString(3, teacher.getSpecialty());
            statement.setInt(4, teacher.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    // Inside TeacherDAOImpl.java
    @Override
    public boolean deleteTeacher(int id) {
        String sql = "DELETE FROM teachers WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    // ... other CRUD operation implementations
}
