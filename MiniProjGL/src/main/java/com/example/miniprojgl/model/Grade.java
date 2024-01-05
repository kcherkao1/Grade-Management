package com.example.miniprojgl.model;

public class Grade {

    private String studentName;
    private String moduleName;
    private int id;
    private int studentId;

    public Grade(int id, String studentName, String moduleName, float grade) {
        this.id=id;
        this.studentName=studentName;
        this.moduleName=moduleName;
        this.grade=grade;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    private int moduleId;
    private float grade;


    // Constructor, Getters, and Setters
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public Grade(int id, int studentId, String studentName, int moduleId, String moduleName, float grade) {
        this.id=id;
        this.studentId=studentId;
        this.studentName = studentName;
        this.moduleId=moduleId;
        this.moduleName = moduleName;
        this.grade=grade;

        // Other initializations...
    }
    public Grade(int id, int studentId, int moduleId, float grade) {
            this.id = id;
            this.studentId = studentId;
            this.moduleId = moduleId;
        this.grade = grade;
    }
    public Grade(int studentId, int moduleId, float grade) {

        this.studentId = studentId;
        this.moduleId = moduleId;
        this.grade = grade;
    }
}
