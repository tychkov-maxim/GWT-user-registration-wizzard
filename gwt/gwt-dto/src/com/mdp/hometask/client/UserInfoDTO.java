package com.mdp.hometask.client;

import java.io.Serializable;
import java.util.Date;

public class UserInfoDTO implements Serializable {
    private String username;
    private String password;
    private String gender;
    private Date dateOfBirth;
    private String address;
    private String phoneNumber;

    public UserInfoDTO() {
    }

    public UserInfoDTO(String username, String password, String gender, Date dateOfBirth, String address, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
