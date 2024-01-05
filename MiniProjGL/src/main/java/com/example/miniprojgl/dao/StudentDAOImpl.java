package com.example.miniprojgl.dao;

import com.example.miniprojgl.model.Student;
import com.example.miniprojgl.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private Connection connection;

    public StudentDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("firstName"));
                student.setLastName(resultSet.getString("lastName"));
                student.setEnrollmentNumber(resultSet.getString("enrollmentNumber"));
                student.setEmail(resultSet.getString("email"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this error
        }
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        Student student = null;
        String sql = "SELECT * FROM students WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    student = new Student();
                    student.setId(resultSet.getInt("id"));
                    student.setFirstName(resultSet.getString("firstName"));
                    student.setLastName(resultSet.getString("lastName"));
                    student.setEnrollmentNumber(resultSet.getString("enrollmentNumber"));
                    student.setEmail(resultSet.getString("email"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this error
        }
        return student;
    }

    @Override
    public boolean addStudent(Student student) {
        String sql = "INSERT INTO students (firstName, lastName, enrollmentNumber, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getEnrollmentNumber());
            preparedStatement.setString(4, student.getEmail());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this error
            return false;
        }
    }

    @Override
    public boolean updateStudent(Student student) {
        String sql = "UPDATE students SET firstName = ?, lastName = ?, enrollmentNumber = ?, email = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getEnrollmentNumber());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setInt(5, student.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this error
            return false;
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this error
            return false;
        }
    }
}
