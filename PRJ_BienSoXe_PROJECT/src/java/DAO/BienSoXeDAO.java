package DAO;

import Model.BienSoXe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BienSoXeDAO extends DBContext {

    private Connection connection;

    public BienSoXeDAO() {
        this.connection = super.connection;
    }

    // Create a new record in the BienSoXe table
    public boolean insertBienSoXe(BienSoXe bienSoXe) {
        try ( PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO [dbo].[BienSoXe] VALUES (?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, bienSoXe.getBienSo());
            preparedStatement.setString(2, bienSoXe.getChuSoHuu());
            preparedStatement.setString(3, bienSoXe.getDiaChiChuSoHuu());
            preparedStatement.setDate(4, new java.sql.Date(bienSoXe.getNgayDangKy().getTime()));
            preparedStatement.setString(5, bienSoXe.getStatus());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieve a BienSoXe record based on the license plate number
    public BienSoXe getBienSoXeByBienSo(String bienSo) {
        try ( PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM [dbo].[BienSoXe] WHERE [BienSo] = ?")) {
            preparedStatement.setString(1, bienSo);

            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToBienSoXe(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Retrieve all BienSoXe records from the table
    public List<BienSoXe> getAllBienSoXe() {
        List<BienSoXe> bienSoXeList = new ArrayList<>();
        try ( PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM [dbo].[BienSoXe]")) {
            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    bienSoXeList.add(mapResultSetToBienSoXe(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bienSoXeList;
    }

    // Update a BienSoXe record
    public void updateBienSoXe(BienSoXe bienSoXe) {
        String xSql = "UPDATE [dbo].[BienSoXe] SET [ChuSoHuu] = ?, [DiaChiChuSoHuu] = ?, [NgayDangKy] = ?, [Status] = ? WHERE [BienSo] = ?";
        try ( PreparedStatement ps = connection.prepareStatement(xSql)) {

            // Set parameters for the prepared statement
            ps.setString(1, bienSoXe.getChuSoHuu());
            ps.setString(2, bienSoXe.getDiaChiChuSoHuu());
            ps.setDate(3, new java.sql.Date(bienSoXe.getNgayDangKy().getTime()));
            ps.setString(4, bienSoXe.getStatus());
            ps.setString(5, bienSoXe.getBienSo());

            // Execute the update query
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Ensure the connection is closed in a finally block
            closeConnection();
        }
    }

    // Delete a BienSoXe record based on the license plate number
    public boolean deleteBienSoXe(String bienSo) {
        try ( PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM [dbo].[BienSoXe] WHERE [BienSo] = ?")) {
            preparedStatement.setString(1, bienSo);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Helper method to map a ResultSet to a BienSoXe object
    private BienSoXe mapResultSetToBienSoXe(ResultSet resultSet) throws SQLException {
        BienSoXe bienSoXe = new BienSoXe();
        bienSoXe.setBienSo(resultSet.getString("BienSo"));
        bienSoXe.setChuSoHuu(resultSet.getString("ChuSoHuu"));
        bienSoXe.setDiaChiChuSoHuu(resultSet.getString("DiaChiChuSoHuu"));
        bienSoXe.setNgayDangKy(resultSet.getDate("NgayDangKy"));
        bienSoXe.setStatus(resultSet.getString("Status"));
        return bienSoXe;
    }
// Close the connection

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BienSoXeDAO dao = new BienSoXeDAO();
        System.out.println(dao.getBienSoXeByBienSo("d"));
    }
}
