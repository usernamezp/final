package com.baizhi.entity;

import java.sql.Date;
import java.util.List;

//专辑
public class Album {
    private int id;
    private String name;//专辑名字
    private String coverlmg;//封面图片
    private int count;//集数（共有多少集）
    private int score;//评分（几颗星）
    private String author;//作者
    private String broadCast;//广播员名字
    private String brief;//简介
    private Date pubishDate;//发布时间
    private List<Chapter> children;

    public Album(int id, String name, String coverlmg, int count, int score, String author, String broadCast, String brief, Date pubishDate, List<Chapter> children) {
        this.id = id;
        this.name = name;
        this.coverlmg = coverlmg;
        this.count = count;
        this.score = score;
        this.author = author;
        this.broadCast = broadCast;
        this.brief = brief;
        this.pubishDate = pubishDate;
        this.children = children;
    }

    public Album() {
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coverlmg='" + coverlmg + '\'' +
                ", count=" + count +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadCast='" + broadCast + '\'' +
                ", brief='" + brief + '\'' +
                ", pubishDate=" + pubishDate +
                ", children=" + children +
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

    public String getCoverlmg() {
        return coverlmg;
    }

    public void setCoverlmg(String coverlmg) {
        this.coverlmg = coverlmg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadCast() {
        return broadCast;
    }

    public void setBroadCast(String broadCast) {
        this.broadCast = broadCast;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getPubishDate() {
        return pubishDate;
    }

    public void setPubishDate(Date pubishDate) {
        this.pubishDate = pubishDate;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }
}
