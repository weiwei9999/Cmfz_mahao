package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Chapter {
    private Integer ID;
    private String title;
    private String size;
    private String duration;
    private String downpath;
    @DateTimeFormat(pattern="yyyy-MM-dd" )
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatedtime;
    private Integer albumid;


    public Chapter() {
    }

    public Chapter(Integer ID, String title, String size, String duration, String downpath, Date updatedtime, Integer albumid) {
        this.ID = ID;
        this.title = title;
        this.size = size;
        this.duration = duration;
        this.downpath = downpath;
        this.updatedtime = updatedtime;
        this.albumid = albumid;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDownpath() {
        return downpath;
    }

    public void setDownpath(String downpath) {
        this.downpath = downpath;
    }

    public Date getUpdatedtime() {
        return updatedtime;
    }

    public void setUpdatedtime(Date updatedtime) {
        this.updatedtime = updatedtime;
    }

    public Integer getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Integer albumid) {
        this.albumid = albumid;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", size='" + size + '\'' +
                ", duration='" + duration + '\'' +
                ", downpath='" + downpath + '\'' +
                ", updatedtime=" + updatedtime +
                ", albumid=" + albumid +
                '}';
    }
}

