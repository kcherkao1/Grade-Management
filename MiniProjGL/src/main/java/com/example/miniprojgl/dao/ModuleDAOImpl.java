package com.example.miniprojgl.dao;

import com.example.miniprojgl.model.Module;
import com.example.miniprojgl.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModuleDAOImpl implements ModuleDAO {

    private Connection connection;

    public ModuleDAOImpl() {
        connection = DatabaseConnection.getConnection();
    }

    @Override
    public List<Module> getAllModules() {
        List<Module> modules = new ArrayList<>();
        String sql = "SELECT * FROM modules";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Module module = new Module(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("semester")
                );
                modules.add(module);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this
        }
        return modules;
    }

    @Override
    public Module getModuleById(int id) {
        Module module = null;
        String sql = "SELECT * FROM modules WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    module = new Module(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("semester")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this
        }
        return module;
    }

    @Override
    public boolean addModule(Module module) {
        String sql = "INSERT INTO modules (name, semester) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, module.getName());
            preparedStatement.setInt(2, module.getSemester());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this
            return false;
        }
    }

    @Override
    public boolean updateModule(Module module) {
        String sql = "UPDATE modules SET name = ?, semester = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, module.getName());
            preparedStatement.setInt(2, module.getSemester());
            preparedStatement.setInt(3, module.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this
            return false;
        }
    }

    @Override
    public boolean deleteModule(int id) {
        String sql = "DELETE FROM modules WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this
            return false;
        }
    }
}
