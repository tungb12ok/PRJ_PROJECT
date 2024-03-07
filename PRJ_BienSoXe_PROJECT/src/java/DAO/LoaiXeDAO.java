/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.LoaiXe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiXeDAO extends DBContext{

    private Connection connection;

    public LoaiXeDAO() {
        this.connection = super.connection;
    }

    public void addLoaiXe(LoaiXe loaiXe) {
        String query = "INSERT INTO LoaiXe (LoaiXe, Description) VALUES (?, ?)";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, loaiXe.getLoaiXe());
            preparedStatement.setString(2, loaiXe.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }

    // Read
    public List<LoaiXe> getAllLoaiXe() {
        List<LoaiXe> loaiXeList = new ArrayList<>();
        String query = "SELECT * FROM LoaiXe";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(query);  ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                LoaiXe loaiXe = new LoaiXe();
                loaiXe.setLoaiXe(resultSet.getString("LoaiXe"));
                loaiXe.setDescription(resultSet.getString("Description"));
                loaiXeList.add(loaiXe);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return loaiXeList;
    }

    // Update
    public void updateLoaiXe(LoaiXe loaiXe) {
        String query = "UPDATE LoaiXe SET Description = ? WHERE LoaiXe = ?";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, loaiXe.getDescription());
            preparedStatement.setString(2, loaiXe.getLoaiXe());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }

    // Delete
    public void deleteLoaiXe(String loaiXeName) {
        String query = "DELETE FROM LoaiXe WHERE LoaiXe = ?";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, loaiXeName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }

    public static void main(String[] args) {
        LoaiXeDAO dao = new LoaiXeDAO();
        System.out.println(dao.getAllLoaiXe());
    }
}
