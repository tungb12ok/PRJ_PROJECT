/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.BienSoXeDAO;
import DAO.ThongTinXeDAO;
import Model.BienSoXe;
import Model.ThongTinXe;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;

/**
 *
 * @author tungl
 */
@WebServlet(name = "RegitControler", urlPatterns = {"/Regit"})
public class RegitControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("DangKyBienSoXe.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve parameters from the registration form
        String licensePlate = request.getParameter("licensePlate");
        String ownerName = request.getParameter("ownerName");
        String ownerAddress = request.getParameter("ownerAddress");
        String registrationDate = request.getParameter("registrationDate");

        if (!validateLicensePlate(licensePlate)) {
            request.setAttribute("messError", "Biển số xe không đúng định dạng!");
            request.getRequestDispatcher("DangKyBienSoXe.jsp").forward(request, response);
            return;
        }

        BienSoXe c = new BienSoXe();
        c.setBienSo(licensePlate);
        c.setChuSoHuu(ownerName);
        c.setDiaChiChuSoHuu(ownerAddress);

        try {
            Date date = Date.valueOf(registrationDate);
            c.setNgayDangKy(date);
        } catch (IllegalArgumentException e) {
            e.printStackTrace(); // Log the error or handle it as needed
        }

        BienSoXeDAO bDAO = new BienSoXeDAO();
        ThongTinXeDAO tDAO = new ThongTinXeDAO();
        ThongTinXe t = new ThongTinXe();
        t.setBienSo(licensePlate);
        t.setStatus("InValid");
        try {
            bDAO.insertBienSoXe(c);
            tDAO.insertThongTinXe(t);
            request.setAttribute("messSuccess", "Regit Successfuly!");
        } catch (Exception e) {
            request.setAttribute("messError", "Regit failed! " + e.getMessage());
        }
        request.getRequestDispatcher("DangKyBienSoXe.jsp").forward(request, response);

    }
    // Validate license plate format

    private boolean validateLicensePlate(String licensePlate) {
        String regex = "^[0-9]{2}-[A-Z][0-9]-[0-9]{4,5}$";
        return licensePlate.matches(regex);
    }

}
