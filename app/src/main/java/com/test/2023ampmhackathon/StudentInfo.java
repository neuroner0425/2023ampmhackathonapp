package com.test.2023ampmhackathon;

public class StudentInfo {
    private String dormitoryName;
    private String studentNumber;
    private String gender;
    private String mbti;
    private boolean isSmoker;
    private boolean isSnorer;

    // 생성자
    public StudentInfo() {
    }

    public StudentInfo(String dormitoryName, String studentNumber, String gender, String mbti, boolean isSmoker, boolean isSnorer) {
        this.dormitoryName = dormitoryName;
        this.studentNumber = studentNumber;
        this.gender = gender;
        this.mbti = mbti;
        this.isSmoker = isSmoker;
        this.isSnorer = isSnorer;
    }

    public String getDormitoryName() {
        return dormitoryName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getMbti() {
        return mbti;
    }

    public boolean isSmoker() {
        return isSmoker;
    }

    public boolean isSnorer() {
        return isSnorer;
    }

    public void setDormitoryName(String dormitoryName) {
        this.dormitoryName = dormitoryName;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMbti(String mbti) {
        this.mbti = mbti;
    }

    public void setIsSmoker(boolean isSmoker) {
        this.isSmoker = isSmoker;
    }

    public void setIsSnorer(boolean isSnorer) {
        this.isSnorer = isSnorer;
    }
}
