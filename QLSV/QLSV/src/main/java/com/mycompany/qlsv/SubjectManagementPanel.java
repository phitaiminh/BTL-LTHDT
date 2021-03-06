/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.qlsv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class SubjectManagementPanel extends javax.swing.JPanel {

    /**
     * Creates new form SubjectManagementPanel
     */
    private DefaultTableModel tblSubject;
    private DefaultTableModel tblScore;
    private Subject sb = new Subject();
    private Student st = new Student();
    private SubjectScore sbs = new SubjectScore();
    private StudentExcute stExc = new StudentExcute();
    private SubjectExcute sbExc = new SubjectExcute();
    private SubjectScoreExcute sbsExc = new SubjectScoreExcute();
    private String sql;
    private Connection conn = DatabaseConnection.getConnection();
    private PreparedStatement ps;
    private ResultSet rs;

    public SubjectManagementPanel() {
        initComponents();
        initTable();
        loadDatatoSubjectTable();
        loadDatatoScoreTable();
    }

    public void initTable() {
        tblSubject = new DefaultTableModel();
        tblSubject.setColumnIdentifiers(new String[]{"Mã môn học", "Tên môn học", "Số tín chỉ"});
        QLMH_SubjectTable.setModel(tblSubject);
        tblScore = new DefaultTableModel();
        tblScore.setColumnIdentifiers(new String[]{"MSSV", "Mã môn học", "Điểm", "Tình trạng"});
        QLMH_ScoreTable.setModel(tblScore);
    }

    public void loadDatatoSubjectTable() {
        SubjectExcute sbExc = new SubjectExcute();
        try {
            List<Subject> list = sbExc.findAll();
            tblSubject.setRowCount(0);
            for (Subject sb : list) {
                tblSubject.addRow(new Object[]{
                    sb.getSubjectCode(), sb.getSubjectTitle(), sb.getCredits()
                });
            }
            tblSubject.fireTableDataChanged();
        } catch (SQLException ex) {
            Logger.getLogger(StudentManagementPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDatatoScoreTable() {
        SubjectScoreExcute sbsExc = new SubjectScoreExcute();
        try {
            List<SubjectScore> list = sbsExc.findAll();
            tblScore.setRowCount(0);
            for (SubjectScore sbs : list) {
                tblScore.addRow(new Object[]{
                    sbs.getMSSV(), sbs.getSubjectCode(), sbs.getScore(), sbs.getPass() == 1 ? "Đạt" : "Trượt"
                });
            }
            tblScore.fireTableDataChanged();
        } catch (SQLException ex) {
            Logger.getLogger(StudentManagementPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getSubjectScoreInformation() {
        sbs.setMSSV(QLMH_MSSV.getText());
        sbs.setSubjectCode(QLMH_SubjectCode.getText());
        sbs.setScore(Float.parseFloat(QLMH_Score.getText()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        QLMH_SubjectTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        QLMH_txtSubjectSearch = new javax.swing.JTextField();
        QLMH_btnSubjectSearch = new javax.swing.JButton();
        QLMH_ShowSubject = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        QLMH_ScoreTable = new javax.swing.JTable();
        QLMH_AddButton = new javax.swing.JButton();
        QLMH_EditButton = new javax.swing.JButton();
        QLMH_DeleteButton = new javax.swing.JButton();
        QLMH_ShowButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        QLMH_MSSV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        QLMH_SubjectCode = new javax.swing.JTextField();
        QLMH_Score = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        QLMH_SubjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(QLMH_SubjectTable);

        jLabel1.setText("Tìm môn học");

        QLMH_btnSubjectSearch.setText("Tìm kiếm");
        QLMH_btnSubjectSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLMH_btnSubjectSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(QLMH_txtSubjectSearch)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(QLMH_btnSubjectSearch)
                .addGap(65, 65, 65))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(QLMH_txtSubjectSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QLMH_btnSubjectSearch)
                .addContainerGap())
        );

        QLMH_ShowSubject.setText("Hiển thị");
        QLMH_ShowSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLMH_ShowSubjectActionPerformed(evt);
            }
        });

        QLMH_ScoreTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        QLMH_ScoreTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QLMH_ScoreTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(QLMH_ScoreTable);

        QLMH_AddButton.setText("Thêm");
        QLMH_AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLMH_AddButtonActionPerformed(evt);
            }
        });

        QLMH_EditButton.setText("Sửa");
        QLMH_EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLMH_EditButtonActionPerformed(evt);
            }
        });

        QLMH_DeleteButton.setText("Xóa");
        QLMH_DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLMH_DeleteButtonActionPerformed(evt);
            }
        });

        QLMH_ShowButton.setText("Hiển thị");
        QLMH_ShowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLMH_ShowButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("MSSV");

        jLabel3.setText("Mã học phần");

        QLMH_Score.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLMH_ScoreActionPerformed(evt);
            }
        });

        jLabel4.setText("Điểm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(QLMH_MSSV)
                            .addComponent(jLabel3)
                            .addComponent(QLMH_SubjectCode, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(QLMH_Score))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(QLMH_ShowButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                .addComponent(QLMH_DeleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(QLMH_AddButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(QLMH_EditButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(QLMH_ShowSubject)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(QLMH_AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QLMH_MSSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(QLMH_EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QLMH_DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QLMH_ShowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QLMH_SubjectCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QLMH_Score, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 152, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(QLMH_ShowSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void QLMH_btnSubjectSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLMH_btnSubjectSearchActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String sbCode = (String) QLMH_txtSubjectSearch.getText();
            sql = "SELECT * FROM subject WHERE SubjectCode = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, sbCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                sb = sbExc.createSubject(rs);
                tblSubject.setRowCount(0);
                tblSubject.addRow(new Object[]{
                    sb.getSubjectCode(), sb.getSubjectTitle(), sb.getCredits()
                });
                tblSubject.fireTableDataChanged();
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy sinh viên phù hợp", "Lỗi khi tìm kiếm", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentManagementPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_QLMH_btnSubjectSearchActionPerformed

    private void QLMH_ShowSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLMH_ShowSubjectActionPerformed
        // TODO add your handling code here:
        loadDatatoSubjectTable();
    }//GEN-LAST:event_QLMH_ShowSubjectActionPerformed

    private void QLMH_ShowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLMH_ShowButtonActionPerformed
        // TODO add your handling code here:
        loadDatatoScoreTable();
    }//GEN-LAST:event_QLMH_ShowButtonActionPerformed

    private void QLMH_ScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLMH_ScoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QLMH_ScoreActionPerformed

    private void QLMH_AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLMH_AddButtonActionPerformed
        // TODO add your handling code here:
        try {
            StringBuilder sb = new StringBuilder();
            getSubjectScoreInformation();
            if (sbs.getMSSV().equals("") || sbs.getSubjectCode().equals("") || QLMH_Score.getText().equals("")) {
                sb.append("Vui lòng nhập chỗ còn thiếu");
            } else if (stExc.findbyMSSV(sbs.getMSSV()) == null || sbExc.findbySubjectCode(sbs.getSubjectCode()) == null){
                sb.append("MSSV hoặc mã học phần không hợp lệ");
            } else if (sbsExc.findbyMSSVandSubjectCode(sbs.getMSSV(), sbs.getSubjectCode()) != null) {
                sb.append("Điểm học phần này của sinh viên đã có");
            }
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(null, sb, "Lỗi khi thêm", JOptionPane.ERROR_MESSAGE);
            } else {
                if (sbsExc.addSubjectScore(sbs)) {
                    JOptionPane.showMessageDialog(null, "Điểm đã được thêm", "Thêm thành công", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Điểm không đưược thêm do lỗi", "Lỗi khi thêm", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentManagementPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_QLMH_AddButtonActionPerformed

    private void QLMH_ScoreTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QLMH_ScoreTableMouseClicked
        // TODO add your handling code here:
        int row = QLMH_ScoreTable.getSelectedRow();
        if (row >= 0) {
            String MSSV = (String) QLMH_ScoreTable.getValueAt(row, 0);
            String SubjectCode = (String) QLMH_ScoreTable.getValueAt(row, 1);
            try {
                sbs = sbsExc.findbyMSSVandSubjectCode(MSSV, SubjectCode);
            } catch (SQLException ex) {
                Logger.getLogger(StudentManagementPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (sbs != null) {
                QLMH_MSSV.setText(sbs.getMSSV());
                QLMH_SubjectCode.setText(sbs.getSubjectCode());
                QLMH_Score.setText(String.valueOf(sbs.getScore()));
            }
        }
    }//GEN-LAST:event_QLMH_ScoreTableMouseClicked

    private void QLMH_EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLMH_EditButtonActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        try {
            if (QLMH_MSSV.getText().equals("") || QLMH_SubjectCode.getText().equals("") || QLMH_Score.getText().equals("") || sbsExc.findbyMSSVandSubjectCode(QLMH_MSSV.getText(), QLMH_SubjectCode.getText()) == null) {
                JOptionPane.showMessageDialog(null, "MSSV và mã học phần đang để trống hoặc không có sẵn dữ liệu trong bản", "Lỗi khi cập nhật", JOptionPane.INFORMATION_MESSAGE);
            } else {
                getSubjectScoreInformation();
                if (JOptionPane.showConfirmDialog(null, "Bạn có xác nhận muốn cập nhật?", "Xác nhận", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {
                        if (sbsExc.updateSubjectScore(sbs)) {
                            JOptionPane.showMessageDialog(null, "Cập nhật thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Lỗi không cập nhật được", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StudentManagementPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentManagementPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_QLMH_EditButtonActionPerformed

    private void QLMH_DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLMH_DeleteButtonActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        try {
            if (QLMH_MSSV.getText().equals("") || QLMH_SubjectCode.getText().equals("") || sbsExc.findbyMSSVandSubjectCode(QLMH_MSSV.getText(), QLMH_SubjectCode.getText()) == null) {
                JOptionPane.showMessageDialog(null, "MSSV đang để trống hoặc không tìm thấy MSSV", "Lỗi khi xóa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                getSubjectScoreInformation();
                if (JOptionPane.showConfirmDialog(null, "Bạn có xác nhận muốn cập nhật sinh viên?", "Xác nhận", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {
                        if (sbsExc.deleteSubjectScore(QLMH_MSSV.getText(),QLMH_SubjectCode.getText())) {
                            JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Lỗi không xóa được", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StudentManagementPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentManagementPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_QLMH_DeleteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton QLMH_AddButton;
    private javax.swing.JButton QLMH_DeleteButton;
    private javax.swing.JButton QLMH_EditButton;
    private javax.swing.JTextField QLMH_MSSV;
    private javax.swing.JTextField QLMH_Score;
    private javax.swing.JTable QLMH_ScoreTable;
    private javax.swing.JButton QLMH_ShowButton;
    private javax.swing.JButton QLMH_ShowSubject;
    private javax.swing.JTextField QLMH_SubjectCode;
    private javax.swing.JTable QLMH_SubjectTable;
    private javax.swing.JButton QLMH_btnSubjectSearch;
    private javax.swing.JTextField QLMH_txtSubjectSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
