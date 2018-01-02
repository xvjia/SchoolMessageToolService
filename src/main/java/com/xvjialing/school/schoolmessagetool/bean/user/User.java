package com.xvjialing.school.schoolmessagetool.bean.user;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String username;

    private String password;

    private Integer role;

    public User(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", username:'" + username + '\'' +
                ", password:'" + password + '\'' +
                ", role:" + role +
                '}';
    }
}