/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAO;
import Model.Course;
import Model.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tungl
 */
public class SendController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        DAO dao = new DAO();
        try {
            request.setAttribute("t", dao.getById(Integer.parseInt(id)));
        } catch (SQLException ex) {
            Logger.getLogger(SendController.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("show").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        DAO dao = new DAO();
        if (idParam != null && !idParam.isEmpty()) {
            // Update existing teacher
            int id = Integer.parseInt(idParam);
            String name = request.getParameter("name");
            Date dob = Date.valueOf(request.getParameter("birthday"));
            String address = request.getParameter("address");
            int courseId = Integer.parseInt(request.getParameter("courses"));
            String teachQual = request.getParameter("teachingQuality");

            // Create Course object with courseId
            Course course = new Course();
            course.setId(courseId);

            Teacher teacher = new Teacher(id, name, dob, address, courseId, teachQual, course);
            try {
                dao.update(teacher);
            } catch (SQLException ex) {
                // Handle exception
            }
        } else {
            // Create new teacher
            String name = request.getParameter("name");
            Date dob = Date.valueOf(request.getParameter("birthday"));
            String address = request.getParameter("address");
            int courseId = Integer.parseInt(request.getParameter("courses"));
            String teachQual = request.getParameter("teachingQuality");

            // Create Course object with courseId
            Course course = new Course();
            course.setId(courseId);

            Teacher teacher = new Teacher(0, name, dob, address, courseId, teachQual, course);
            try {
                dao.add(teacher);
            } catch (SQLException ex) {
                // Handle exception
            }
        }
        request.getRequestDispatcher("show").forward(request, response);

    }

}
