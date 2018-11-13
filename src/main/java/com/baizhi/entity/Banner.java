package com.baizhi.entity;

/*
* 轮播图
* */

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Banner {
    private Integer id;
    private String title;
    private String descstr;
    private Integer status;
    @DateTimeFormat(pattern="yyyy-MM-dd" )
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String imgpth;

    public Banner() {
    }

    public Banner(Integer id, String title, String descstr, Integer status, Date date, String imgpth) {
        this.id = id;
        this.title = title;
        this.descstr = descstr;
        this.status = status;
        this.date = date;
        this.imgpth = imgpth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescstr() {
        return descstr;
    }

    public void setDescstr(String descstr) {
        this.descstr = descstr;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImgpth() {
        return imgpth;
    }

    public void setImgpth(String imgpth) {
        this.imgpth = imgpth;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", descstr='" + descstr + '\'' +
                ", status=" + status +
                ", date=" + date +
                ", imgpth='" + imgpth + '\'' +
                '}';
    }
}
