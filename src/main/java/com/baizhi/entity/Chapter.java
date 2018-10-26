package com.baizhi.entity;

public class Chapter {
    private int id;
    private String name;//章节名字
    private String url;//章节路径
    private String size;//章节大小
    private String duration;//章节时长
    private int album_id;

    public Chapter() {
    }

    public Chapter(int id, String name, String url, String size, String duration, int album_id) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.size = size;
        this.duration = duration;
        this.album_id = album_id;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", size='" + size + '\'' +
                ", duration='" + duration + '\'' +
                ", album_id=" + album_id +
                '}';
    }
}
