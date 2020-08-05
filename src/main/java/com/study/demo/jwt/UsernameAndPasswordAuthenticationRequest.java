package com.study.demo.jwt;

public class UsernameAndPasswordAuthenticationRequest {
    private String username;
    private String password;

    public UsernameAndPasswordAuthenticationRequest() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
