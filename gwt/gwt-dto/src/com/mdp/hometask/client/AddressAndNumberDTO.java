package com.mdp.hometask.client;

import java.io.Serializable;

public class AddressAndNumberDTO implements Serializable {
    private String address;
    private String phoneNumber;

    public AddressAndNumberDTO() {
    }

    public AddressAndNumberDTO(String address, String phoneNumber) {
        this.address = address;
        this.phoneNumber = phoneNumber;
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
