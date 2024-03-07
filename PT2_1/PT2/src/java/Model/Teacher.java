/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

public class Teacher {

    int id;
    String name;
    Date dob;
    String address;
    int courseId;
    String teachQual;

    private Course c;

    public Teacher() {
    }

    public Teacher(int id, String name, Date dob, String address, int courseId, String teachQual, Course c) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.courseId = courseId;
        this.teachQual = teachQual;
        this.c = c;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTeachQual() {
        return teachQual;
    }

    public void setTeachQual(String teachQual) {
        this.teachQual = teachQual;
    }

    public Course getC() {
        return c;
    }

    public void setC(Course c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", name=" + name + ", dob=" + dob + ", address=" + address + ", courseId=" + courseId + ", teachQual=" + teachQual + ", c=" + c + '}';
    }

}
