/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Course;
import Model.Teacher;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO extends dal.DBContext {

    public List<Teacher> getAll() {
        List<Teacher> teachers = new ArrayList<>();
        String query = "SELECT t.[id] AS teacher_id, t.[name] AS teacher_name, t.[dob] AS teacher_dob, t.[address] AS teacher_address, t.[courseid] AS teacher_courseid, t.[teachqual] AS teacher_teachqual, "
                + "c.[id] AS course_id, c.[name] AS course_name, c.[group] AS course_group "
                + "FROM [dbo].[Teacher] t "
                + "JOIN [dbo].[Course] c ON t.[courseid] = c.[id]";
        try ( PreparedStatement statement = connection.prepareStatement(query);  ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getInt("teacher_id"));
                teacher.setName(resultSet.getString("teacher_name"));
                teacher.setDob(resultSet.getDate("teacher_dob"));
                teacher.setAddress(resultSet.getString("teacher_address"));
                teacher.setCourseId(resultSet.getInt("teacher_courseid"));
                teacher.setTeachQual(resultSet.getString("teacher_teachqual"));

                // Course details
                Course course = new Course();
                course.setId(resultSet.getInt("course_id"));
                course.setName(resultSet.getString("course_name"));
                course.setGroup(resultSet.getInt("course_group"));

                teacher.setC(course);

                teachers.add(teacher);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teachers;
    }

    public Teacher getById(int id) {
        Teacher teacher = null;
        String query = "SELECT t.[id] AS teacher_id, t.[name] AS teacher_name, t.[dob] AS teacher_dob, t.[address] AS teacher_address, t.[courseid] AS teacher_courseid, t.[teachqual] AS teacher_teachqual, "
                + "c.[id] AS course_id, c.[name] AS course_name, c.[group] AS course_group "
                + "FROM [dbo].[Teacher] t "
                + "JOIN [dbo].[Course] c ON t.[courseid] = c.[id] "
                + "WHERE t.id = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    teacher = new Teacher();
                    teacher.setId(resultSet.getInt("teacher_id"));
                    teacher.setName(resultSet.getString("teacher_name"));
                    teacher.setDob(resultSet.getDate("teacher_dob"));
                    teacher.setAddress(resultSet.getString("teacher_address"));
                    teacher.setCourseId(resultSet.getInt("teacher_courseid"));
                    teacher.setTeachQual(resultSet.getString("teacher_teachqual"));

                    // Course details
                    Course course = new Course();
                    course.setId(resultSet.getInt("course_id"));
                    course.setName(resultSet.getString("course_name"));
                    course.setGroup(resultSet.getInt("course_group"));

                    teacher.setC(course);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teacher;
    }

// Method to add a new teacher
    public void add(Teacher teacher) {
        String query = "INSERT INTO [dbo].[Teacher] ([name], [dob], [address], [courseid], [teachqual]) VALUES (?, ?, ?, ?, ?)";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, teacher.getName());
            statement.setDate(2, teacher.getDob());
            statement.setString(3, teacher.getAddress());
            statement.setInt(4, teacher.getCourseId());
            statement.setString(5, teacher.getTeachQual());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to update an existing teacher
    public void update(Teacher teacher) {
        String query = "UPDATE [dbo].[Teacher] SET [name] = ?, [dob] = ?, [address] = ?, [courseid] = ?, [teachqual] = ? WHERE [id] = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, teacher.getName());
            statement.setDate(2, teacher.getDob());
            statement.setString(3, teacher.getAddress());
            statement.setInt(4, teacher.getCourseId());
            statement.setString(5, teacher.getTeachQual());
            statement.setInt(6, teacher.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Method to retrieve a list of all courses

    public List<Course> getList() {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT [id], [name], [group] FROM [dbo].[Course]";
        try ( PreparedStatement statement = connection.prepareStatement(query);  ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Course course = new Course();
                course.setId(resultSet.getInt("id"));
                course.setName(resultSet.getString("name"));
                course.setGroup(resultSet.getInt("group"));
                courses.add(course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courses;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        System.out.println(dao.getAll());
    }
}
