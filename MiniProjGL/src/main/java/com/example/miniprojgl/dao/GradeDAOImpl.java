package com.example.miniprojgl.dao;

import com.example.miniprojgl.model.Grade;
import com.example.miniprojgl.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradeDAOImpl implements GradeDAO {

    private Connection connection;

    public GradeDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public List<Grade> getGradesByStudent(int studentId) {
        List<Grade> grades = new ArrayList<>();
        String sql = "SELECT * FROM grades WHERE student_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Grade grade = new Grade(
                        resultSet.getInt("id"),
                        resultSet.getInt("student_id"),
                        resultSet.getInt("module_id"),
                        resultSet.getFloat("grade")
                );
                grades.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this error
        }
        return grades;
    }

    @Override
    public List<Grade> getGradesByModule(int moduleId) {
        List<Grade> grades = new ArrayList<>();
        String sql = "SELECT * FROM grades WHERE module_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, moduleId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Grade grade = new Grade(
                        resultSet.getInt("id"),
                        resultSet.getInt("student_id"),
                        resultSet.getInt("module_id"),
                        resultSet.getFloat("grade")
                );
                grades.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this error
        }
        return grades;
    }

    @Override
    public boolean addGrade(Grade grade) {
        String sql = "INSERT INTO grades (student_id, module_id, grade) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, grade.getStudentId());
            preparedStatement.setInt(2, grade.getModuleId());
            preparedStatement.setFloat(3, grade.getGrade());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this error
            return false;
        }
    }

    @Override
    public boolean updateGrade(Grade grade) {
        String sql = "UPDATE grades SET student_id = ?, module_id = ?, grade = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, grade.getStudentId());
            preparedStatement.setInt(2, grade.getModuleId());
            preparedStatement.setFloat(3, grade.getGrade());
            preparedStatement.setInt(4, grade.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this error
            return false;
        }
    }

    @Override
    public boolean deleteGrade(int id) {
        String sql = "DELETE FROM grades WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this error
            return false;
        }
    }

    public double getAverageGradeForModule(int moduleId) {
        String sql = "SELECT AVG(grade) as average FROM grades WHERE module_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, moduleId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble("average");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log this error
        }
        return 0;
    }


    @Override
    public List<Grade> getAllGrades() {
        List<Grade> grades = new ArrayList<>();
        String sql = "SELECT g.id, s.id as student_id, CONCAT(s.firstName, ' ', s.lastName) as student_name, m.id as module_id, m.name as module_name, g.grade " +
                "FROM grades g " +
                "JOIN students s ON g.student_id = s.id " +
                "JOIN modules m ON g.module_id = m.id";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                // Create a new Grade object and populate its fields using the correct column names
                Grade grade = new Grade(
                        resultSet.getInt("id"),
                        resultSet.getInt("student_id"), // Use the correct column alias 'student_id'
                        resultSet.getInt("module_id"), // Use the correct column alias 'module_id'
                        resultSet.getFloat("grade")
                );
                // Now set the student and module names which are not part of the Grade constructor
                grade.setStudentName(resultSet.getString("student_name")); // Use the correct column alias 'student_name'
                grade.setModuleName(resultSet.getString("module_name")); // Use the correct column alias 'module_name'
                grades.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider more robust error handling
        }
        System.out.println("Number of grades retrieved: " + grades.size());
        return grades;
    }



}
