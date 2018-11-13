package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
/*
* 专辑类
* */

public class Album {
    private Integer id;
    private String title;
    private String coverimg;
    private Integer score;
    private Integer count;
    private String author;
    private String broadcast;
    private String brief;
    @DateTimeFormat(pattern="yyyy-MM-dd" )
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishdate;
    private List<Chapter> children;

    public Album() {
    }

    public Album(Integer id, String title, String coverimg, Integer score, Integer count, String author, String broadcast, String brief, Date publishdate, List<Chapter> children) {
        this.id = id;
        this.title = title;
        this.coverimg = coverimg;
        this.score = score;
        this.count = count;
        this.author = author;
        this.broadcast = broadcast;
        this.brief = brief;
        this.publishdate = publishdate;
        this.children = children;
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

    public String getCoverimg() {
        return coverimg;
    }

    public void setCoverimg(String coverimg) {
        this.coverimg = coverimg;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", coverimg='" + coverimg + '\'' +
                ", score=" + score +
                ", count=" + count +
                ", author='" + author + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", brief='" + brief + '\'' +
                ", publishdate=" + publishdate +
                ", children=" + children +
                '}';
    }
}

