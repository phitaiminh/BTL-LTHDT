/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlsv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class StudentExcute {

    //private Student sv;
    private Connection conn = DatabaseConnection.getConnection();
    private PreparedStatement ps;
    private String sql;
    ResultSet rs;

    public StudentExcute() {

    }

    public Student createStudent(ResultSet rs) throws SQLException {
        Student sv = new Student();
        sv.setMSSV(rs.getString("MSSV"));
        sv.setName(rs.getString("Name"));
        sv.setDob(rs.getDate("Dob"));
        sv.setAddress(rs.getString("Address"));
        sv.setGender(rs.getString("Gender"));
        sv.setSchoolYear(rs.getString("SchoolYear"));
        sv.setDepartment(rs.getString("Department"));
        sv.setLop(rs.getString("Class"));
        sv.setPhoneNumber(rs.getString("PhoneNumber"));
        return sv;
    }

    public boolean addStudent(Student sv) throws SQLException {
        sql = "SELECT MSSV FROM student WHERE MSSV = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, sv.getMSSV());
        rs = ps.executeQuery();
        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Trùng MSSV của sinh viên khác", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            sql = "INSERT INTO student VALUES(?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, sv.getMSSV());
            ps.setString(2, sv.getName());
            ps.setDate(3, sv.getDob());
            ps.setString(4, sv.getAddress());
            ps.setString(5, sv.getGender());
            ps.setString(6, sv.getSchoolYear());
            ps.setString(7, sv.getDepartment());
            ps.setString(8, sv.getLop());
            ps.setString(9, sv.getPhoneNumber());
        }
        return ps.executeUpdate() > 0;
    }

    public List<Student> findAll() throws SQLException {
        List<Student> list = new ArrayList<>();
        sql = "SELECT * FROM student";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Student sv = createStudent(rs);
            list.add(sv);
        }
        return list;
    }

    public boolean updateStudent(Student sv) throws SQLException {
        sql = "UPDATE student\n"
                + "SET Name = ?, Dob = ?, Address = ?, Gender = ?, SchoolYear = ?, Department = ?, Class = ?, PhoneNumber = ?\n"
                + "WHERE MSSV = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, sv.getName());
        ps.setDate(2, sv.getDob());
        ps.setString(3, sv.getAddress());
        ps.setString(4, sv.getGender());
        ps.setString(5, sv.getSchoolYear());
        ps.setString(6, sv.getDepartment());
        ps.setString(7, sv.getLop());
        ps.setString(8, sv.getPhoneNumber());
        ps.setString(9, sv.getMSSV());
        return ps.executeUpdate()>0;
    }
    public boolean deleteStudent(String MSSV) throws SQLException {
        sql = "DELETE FROM student WHERE MSSV = ?;";
        ps = conn.prepareStatement(sql);
        ps.setString(1, MSSV);
        return ps.executeUpdate()>0;
    }
    public Student findbyMSSV(String MSSV) throws SQLException{
        sql = "SELECT * FROM student WHERE MSSV = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, MSSV);
        rs = ps.executeQuery();
        if (rs.next()){
            return createStudent(rs);
        }
        else return null;
    }
}
