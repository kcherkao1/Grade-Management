package com.example.miniprojgl.dao;

import com.example.miniprojgl.model.User;
import java.util.List;

public interface UserDAO {
    User getUserById(int id);
    List<User> getAllUsers();
    boolean insertUser(User user);
    boolean updateUser(User user);

    User authenticateUser(String username, String password);

    boolean deleteUser(int id);
}
