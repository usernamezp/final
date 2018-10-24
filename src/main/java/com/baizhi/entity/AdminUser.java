package com.baizhi.entity;

public class AdminUser {
    private int id;
    private String name;
    private String password;

    public AdminUser(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public AdminUser() {
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
