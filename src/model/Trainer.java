/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Leyteris
 */
public class Trainer {

    private long trainerId;
    private String firstName;
    private String lastName;
    private String subject;

    public Trainer() {
    }

    public Trainer(long trainer_id, String firstName, String lastName, String subject) {
        this.trainerId = trainer_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    public long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(long trainerId) {
        this.trainerId = trainerId;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
}
