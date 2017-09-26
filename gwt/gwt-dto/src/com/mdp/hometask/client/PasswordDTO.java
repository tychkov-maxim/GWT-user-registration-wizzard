package com.mdp.hometask.client;

import java.io.Serializable;

public class PasswordDTO implements Serializable {
    private String password;

    public PasswordDTO() {
    }

    public PasswordDTO(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
