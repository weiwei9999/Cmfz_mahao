package com.baizhi.entity;

import java.util.List;
/*
* 菜单类
* */
public class Menu {
    private  int id;
    private  String title;
    private  String iconCls;
    private  int parentid;
    private  String href;
    private List<Menu> menu;

    public Menu() {
    }

    public Menu(int id, String title, String iconCls, int parentid, String href, List<Menu> menu) {
        this.id = id;
        this.title = title;
        this.iconCls = iconCls;
        this.parentid = parentid;
        this.href = href;
        this.menu = menu;
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

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", parentid=" + parentid +
                ", href='" + href + '\'' +
                ", menu=" + menu +
                '}';
    }
}
