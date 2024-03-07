package DAO;

import Model.ThongTinXe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongTinXeDAO extends DBContext {

    private Connection connection;

    public ThongTinXeDAO() {
        this.connection = super.connection;
    }

    // Create a new record in the ThongTinXe table
    public boolean insertThongTinXe(ThongTinXe thongTinXe) {
        try ( PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO [dbo].[ThongTinXe] VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, thongTinXe.getBienSo());
            preparedStatement.setString(2, thongTinXe.getLoaiXe());
            preparedStatement.setString(3, thongTinXe.getNhanHieu());
            preparedStatement.setString(4, thongTinXe.getMauSac());
            preparedStatement.setInt(5, thongTinXe.getNamSanXuat());
            preparedStatement.setString(6, thongTinXe.getSoKhung());
            preparedStatement.setString(7, thongTinXe.getSoMay());
            preparedStatement.setString(8, thongTinXe.getStatus());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieve a ThongTinXe record based on the license plate number
    public ThongTinXe getThongTinXeByBienSo(String bienSo) {
        try ( PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM [dbo].[ThongTinXe] WHERE [BienSo] = ?")) {
            preparedStatement.setString(1, bienSo);

            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    ThongTinXe thongTinXe = new ThongTinXe();
                    thongTinXe.setBienSo(resultSet.getString("BienSo"));
                    thongTinXe.setLoaiXe(resultSet.getString("LoaiXe"));
                    thongTinXe.setNhanHieu(resultSet.getString("NhanHieu"));
                    thongTinXe.setMauSac(resultSet.getString("MauSac"));
                    thongTinXe.setNamSanXuat(resultSet.getInt("NamSanXuat"));
                    thongTinXe.setSoKhung(resultSet.getString("SoKhung"));
                    thongTinXe.setSoMay(resultSet.getString("SoMay"));
                    thongTinXe.setStatus(resultSet.getString("Status"));
                    return thongTinXe;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Retrieve all ThongTinXe records from the table
    public List<ThongTinXe> getAllThongTinXe() {
        List<ThongTinXe> thongTinXeList = new ArrayList<>();
        try ( PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM [dbo].[ThongTinXe]")) {
            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    ThongTinXe thongTinXe = new ThongTinXe();
                    thongTinXe.setBienSo(resultSet.getString("BienSo"));
                    thongTinXe.setLoaiXe(resultSet.getString("LoaiXe"));
                    thongTinXe.setNhanHieu(resultSet.getString("NhanHieu"));
                    thongTinXe.setMauSac(resultSet.getString("MauSac"));
                    thongTinXe.setNamSanXuat(resultSet.getInt("NamSanXuat"));
                    thongTinXe.setSoKhung(resultSet.getString("SoKhung"));
                    thongTinXe.setSoMay(resultSet.getString("SoMay"));
                    thongTinXe.setStatus(resultSet.getString("Status"));
                    thongTinXeList.add(thongTinXe);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thongTinXeList;
    }

    // Update a ThongTinXe record
    public boolean updateThongTinXe(ThongTinXe thongTinXe) {
        try ( PreparedStatement preparedStatement = connection.prepareStatement("UPDATE [dbo].[ThongTinXe] SET [LoaiXe] = ?, [NhanHieu] = ?, [MauSac] = ?, [NamSanXuat] = ?, [SoKhung] = ?, [SoMay] = ?, [Status] = ? WHERE [BienSo] = ?")) {
            preparedStatement.setString(1, thongTinXe.getLoaiXe());
            preparedStatement.setString(2, thongTinXe.getNhanHieu());
            preparedStatement.setString(3, thongTinXe.getMauSac());
            preparedStatement.setInt(4, thongTinXe.getNamSanXuat());
            preparedStatement.setString(5, thongTinXe.getSoKhung());
            preparedStatement.setString(6, thongTinXe.getSoMay());
            preparedStatement.setString(7, thongTinXe.getStatus());
            preparedStatement.setString(8, thongTinXe.getBienSo());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a ThongTinXe record based on the license plate number
    public boolean deleteThongTinXe(String bienSo) {
        try ( PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM [dbo].[ThongTinXe] WHERE [BienSo] = ?")) {
            preparedStatement.setString(1, bienSo);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        ThongTinXeDAO dao = new ThongTinXeDAO();
        System.out.println(dao.getAllThongTinXe());
    }
}
