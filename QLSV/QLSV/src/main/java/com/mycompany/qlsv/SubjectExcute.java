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
public class SubjectExcute {
    private Connection conn = DatabaseConnection.getConnection();
    private PreparedStatement ps;
    private String sql;
    ResultSet rs;
    
    public SubjectExcute(){
        
    }
    
    public Subject createSubject(ResultSet rs) throws SQLException {
        Subject sb = new Subject();
        sb.setSubjectCode(rs.getString(1));
        sb.setSubjectTitle(rs.getString(2));
        sb.setCredits(rs.getInt(3));
        return sb;
    }
    
    public List<Subject> findAll() throws SQLException {
        List<Subject> list = new ArrayList<>();
        sql = "SELECT * FROM subject";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Subject sb = createSubject(rs);
            list.add(sb);
        }
        return list;
    }
    
    public Subject findbySubjectCode(String SubjectCode) throws SQLException{
        sql = "SELECT * FROM subject WHERE SubjectCode = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, SubjectCode);
        rs = ps.executeQuery();
        if (rs.next()){
            return createSubject(rs);
        }
        else return null;
    }
}
