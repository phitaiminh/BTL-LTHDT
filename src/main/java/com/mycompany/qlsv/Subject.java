/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlsv;

/**
 *
 * @author Admin
 */
public class Subject {
    private String SubjectCode; // Mã môn học
    private String SubjectTitle; // Tên môn học
    private int Credits; // Số tín chỉ
    
    public Subject(){
        
    }
    
    // Getters

    public String getSubjectCode() {
        return SubjectCode;
    }

    public String getSubjectTitle() {
        return SubjectTitle;
    }

    public int getCredits() {
        return Credits;
    }
    
    // Setters
    public void setSubjectCode(String SubjectCode) {
        this.SubjectCode = SubjectCode;
    }

    public void setSubjectTitle(String SubjectTitle) {
        this.SubjectTitle = SubjectTitle;
    }

    public void setCredits(int Credits) {
        this.Credits = Credits;
    }

    
}
