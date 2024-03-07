/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.LoaiXeDAO;
import DAO.ThongTinXeDAO;
import Model.LoaiXe;
import Model.ThongTinXe;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author tungl
 */
@WebServlet(name = "UpdateVehicleController", urlPatterns = {"/UpdateVehicle"})
public class UpdateThongTinXeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        ThongTinXe t = null;
        ThongTinXeDAO tDAO = new ThongTinXeDAO();
        LoaiXeDAO lDAO = new LoaiXeDAO();
        List<LoaiXe> l = lDAO.getAllLoaiXe();
        request.setAttribute("listXe", l);
        if (id != null) {
            t = tDAO.getThongTinXeByBienSo(id);
            request.setAttribute("thongTinXe", t);
        }
        if (t != null) {
            request.getRequestDispatcher("CapNhatThongTinXe.jsp").forward(request, response);
            return;
        }
        response.sendRedirect("error.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ThongTinXeDAO tDAO = new ThongTinXeDAO();

        try {
            // Retrieve parameters from the form
            String bienSo = request.getParameter("bienSo");
            String loaiXe = request.getParameter("loaiXe");
            String nhanHieu = request.getParameter("nhanHieu");
            String mauSac = request.getParameter("mauSac");
            int namSanXuat = Integer.parseInt(request.getParameter("namSanXuat"));
            String soKhung = request.getParameter("soKhung");
            String soMay = request.getParameter("soMay");

            // Create a ThongTinXe object with the updated information
            ThongTinXe updatedThongTinXe = new ThongTinXe();
            updatedThongTinXe.setBienSo(bienSo);
            updatedThongTinXe.setLoaiXe(loaiXe);
            updatedThongTinXe.setNhanHieu(nhanHieu);
            updatedThongTinXe.setMauSac(mauSac);
            updatedThongTinXe.setNamSanXuat(namSanXuat);
            updatedThongTinXe.setSoKhung(soKhung);
            updatedThongTinXe.setSoMay(soMay);

            tDAO.updateThongTinXe(updatedThongTinXe);
            // Set success message
            request.setAttribute("messSuccess", "Vehicle information updated successfully.");

            // Forward to a success page or display success message
            RequestDispatcher dispatcher = request.getRequestDispatcher("update_success.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Set error message
            request.setAttribute("messError", "Error updating vehicle information.");

            // Forward to an error page or display error message
            RequestDispatcher dispatcher = request.getRequestDispatcher("update_error.jsp");
            dispatcher.forward(request, response);
        }
    }

}
