/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlsv;

/**
 *
 * @author Admin
 */
public class SubjectScore {
    private String MSSV;
    private String SubjectCode;
    private float Score;
    private int pass;
    
    public SubjectScore(){
        
    }
    
    // Getters
    public String getMSSV() {
        return MSSV;
    }

    public String getSubjectCode() {
        return SubjectCode;
    }

    public float getScore() {
        return Score;
    }

    public int getPass() {
        return pass;
    }
    
    // Setters
    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public void setSubjectCode(String SubjectCode) {
        this.SubjectCode = SubjectCode;
    }

    public void setScore(float Score) {
        this.Score = Score;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }
    
}
