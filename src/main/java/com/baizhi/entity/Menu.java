package com.baizhi.entity;

import java.util.List;

public class Menu {
    private int id;
    private String title;
    private int parent_id;
    private String iconCls;
    private String url;
    private List<Menu> menulist;

    public Menu() {
    }

    public Menu(int id, String title, int parent_id, String iconCls, String url, List<Menu> menulist) {
        this.id = id;
        this.title = title;
        this.parent_id = parent_id;
        this.iconCls = iconCls;
        this.url = url;
        this.menulist = menulist;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", parent_id=" + parent_id +
                ", iconCls='" + iconCls + '\'' +
                ", url='" + url + '\'' +
                ", menulist=" + menulist +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Menu> getMenulist() {
        return menulist;
    }

    public void setMenulist(List<Menu> menulist) {
        this.menulist = menulist;
    }
}
