/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DBContext {

    private Connection connection;

    public UserDAO() {
        this.connection = super.connection;
    }

    // Create
    public void addUser(Users user) {
        String query = "INSERT INTO Users (username, password, name, role, status) VALUES (?, ?, ?, ?, ?)";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setBoolean(5, user.isStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }

    public Users login(String username, String password) {
        String query = "SELECT * FROM Users WHERE username = ? AND password = ? AND status = 1";
        Users user = null;

        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = new Users();
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setName(resultSet.getString("name"));
                    user.setRole(resultSet.getString("role"));
                    user.setStatus(resultSet.getBoolean("status"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return user;
    }

    // Read
    public Users getUserByUsername(String username) {
        String query = "SELECT * FROM Users WHERE username = ?";
        Users user = null;

        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);

            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = new Users();
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setName(resultSet.getString("name"));
                    user.setRole(resultSet.getString("role"));
                    user.setStatus(resultSet.getBoolean("status"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return user;
    }

    // Update login status
    public void updateLoginStatus(String username, boolean newStatus) {
        String query = "UPDATE Users SET status = ? WHERE username = ?";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setBoolean(1, newStatus);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }

    public List<Users> getListAccounts() {
        List<Users> userList = new ArrayList<>();
        String query = "SELECT * FROM Users WHERE role != 'ADMIN'";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Users user = new Users();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setRole(resultSet.getString("role"));
                user.setStatus(resultSet.getBoolean("status"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return userList;
    }
    // Delete (if needed)
    // ...
    // Other methods as needed
}
