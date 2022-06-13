/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlsv;

/**
 *
 * @author Admin
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SubjectScoreExcute {

    private Connection conn = DatabaseConnection.getConnection();
    private PreparedStatement ps;
    private String sql;
    ResultSet rs;

    public SubjectScoreExcute() {

    }
    
    public SubjectScore createSubjectScore(ResultSet rs) throws SQLException{
        SubjectScore sbc = new SubjectScore();
        sbc.setMSSV(rs.getString(1));
        sbc.setSubjectCode(rs.getString(2));
        sbc.setScore(rs.getFloat(3));
        sbc.setPass(rs.getInt(4));
        return sbc;
    }
    
    public List<SubjectScore> findAll() throws SQLException{
        List<SubjectScore> list = new ArrayList<>();
        sql = "SELECT * FROM subject_score";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            SubjectScore sbc = createSubjectScore(rs);
            list.add(sbc);
        }
        return list;
    }
    
    public SubjectScore findbyMSSVandSubjectCode(String MSSV, String SubjectCode) throws SQLException{
        sql = "SELECT * FROM subject_score WHERE MSSV = ? AND SubjectCode = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, MSSV);
        ps.setString(2, SubjectCode);
        rs = ps.executeQuery();
        if (rs.next()){
            return createSubjectScore(rs);
        }
        else return null;
    }
    
    public boolean addSubjectScore(SubjectScore sbs) throws SQLException {
        sql = "SELECT MSSV, SubjectCode FROM subject_score WHERE MSSV = ? AND SubjectCode = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, sbs.getMSSV());
        ps.setString(2, sbs.getSubjectCode());
        rs = ps.executeQuery();
        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Trùng MSSV của sinh viên khác", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            sql = "INSERT INTO subject_score VALUES(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, sbs.getMSSV());
            ps.setString(2, sbs.getSubjectCode());
            ps.setFloat(3, sbs.getScore());
            ps.setInt(4, sbs.getScore()>=4 ? 1 : 0);
        }
        return ps.executeUpdate() > 0;
    }
    
    public boolean updateSubjectScore(SubjectScore sbs) throws SQLException {
        sql = "UPDATE subject_score\n"
                + "SET Score = ?, Pass = ?\n"
                + "WHERE MSSV = ? AND SubjectCode = ?";
        ps = conn.prepareStatement(sql);
        ps.setFloat(1, sbs.getScore());
        ps.setInt(2, sbs.getScore()>=4 ? 1 : 0);
        ps.setString(3, sbs.getMSSV());
        ps.setString(4, sbs.getSubjectCode());
        return ps.executeUpdate()>0;
    }
    
    public boolean deleteSubjectScore(String MSSV, String SubjectCode) throws SQLException {
        sql = "DELETE FROM subject_score WHERE MSSV = ? AND SubjectCode = ?;";
        ps = conn.prepareStatement(sql);
        ps.setString(1, MSSV);
        ps.setString(2, SubjectCode);
        return ps.executeUpdate()>0;
    }
}
