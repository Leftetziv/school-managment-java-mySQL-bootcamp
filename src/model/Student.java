/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Leyteris
 */
public class Student {

    private long studentId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Double tuitionFees;

    public Student() {
    }

    public Student(long student_id, String firstName, String lastName, LocalDate dateOfBirth, Double tuition_fees) {
        this.studentId = student_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuition_fees;
    }

    public Double getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(Double tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }    
    
}
