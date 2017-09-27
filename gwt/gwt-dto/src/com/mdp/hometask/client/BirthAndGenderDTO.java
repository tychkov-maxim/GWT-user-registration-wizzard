package com.mdp.hometask.client;

import java.io.Serializable;
import java.util.Date;

public class BirthAndGenderDTO implements Serializable {
    private String gender;
    private Date dateOfBirth;

    public BirthAndGenderDTO() {
    }

    public BirthAndGenderDTO(String gender, Date dateOfBirth) {
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
