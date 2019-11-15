package com.kebo.springjpa.po;


import javax.persistence.*;

/**
 * @description:
 * @Author: kb
 * @Date: 2019-11-15 11:27
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    private String userOid;
    private String userName;
    private String userPass;
    private String userRole;
    private String userTime;

    public String getUserOid() {
        return userOid;
    }

    public void setUserOid(String userOid) {
        this.userOid = userOid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserTime() {
        return userTime;
    }

    public void setUserTime(String userTime) {
        this.userTime = userTime;
    }

    public User(String userOid, String userName, String userPass, String userRole, String userTime) {
        this.userOid = userOid;
        this.userName = userName;
        this.userPass = userPass;
        this.userRole = userRole;
        this.userTime = userTime;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userOid='" + userOid + '\'' +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userRole='" + userRole + '\'' +
                ", userTime='" + userTime + '\'' +
                '}';
    }
}
