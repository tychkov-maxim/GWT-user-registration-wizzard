package com.mdp.hometask.client;

import java.io.Serializable;

public class UsernameDTO implements Serializable{
    private String username;

    public UsernameDTO() {
    }

    public UsernameDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
