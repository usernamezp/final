package com.baizhi.entity;

import java.sql.Date;
//轮播图
public class Banner {
    private int id;
    private String name;
    private String url;
    private int status;
    private Date createDate;
    private String description;

    public Banner(int id, String name, String url, int status, Date createDate, String description) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.status = status;
        this.createDate = createDate;
        this.description = description;
    }

    public Banner() {
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", description='" + description + '\'' +
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
