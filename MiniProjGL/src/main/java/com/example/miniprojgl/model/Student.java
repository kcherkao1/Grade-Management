package com.example.miniprojgl.model;

public class Student {
    private int id;
    private String firstName;
    private String lastName;

    public Student(int id, String firstName, String lastName, String enrollmentNumber, String email) {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.enrollmentNumber=enrollmentNumber;
        this.email=email;
    }
    public Student(String firstName, String lastName, String enrollmentNumber, String email) {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.enrollmentNumber=enrollmentNumber;
        this.email=email;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String enrollmentNumber;
    private String email;

    // Constructor, Getters, and Setters
}
