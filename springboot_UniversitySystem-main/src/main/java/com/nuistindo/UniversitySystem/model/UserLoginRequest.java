package com.nuistindo.UniversitySystem.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserLoginRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserLoginRequest {
    @XmlElement(name = "username")
    private String username;

    @XmlElement(name = "password")
    private String password;


    public UserLoginRequest() {
    }

    public UserLoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
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
}
