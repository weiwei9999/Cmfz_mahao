package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.swing.border.TitledBorder;
import java.util.Date;
/*
* 章节类
* */

public class Article {
    private Integer id;
    private String title;
    private String content;
    @DateTimeFormat(pattern="yyyy-MM-dd" )
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String insertimg;
    private Integer guruid;

    public Article() {
    }

    public Article(Integer id, String title, String content, Date date, String insertimg, Integer guruid) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.insertimg = insertimg;
        this.guruid = guruid;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInsertimg() {
        return insertimg;
    }

    public void setInsertimg(String insertimg) {
        this.insertimg = insertimg;
    }

    public Integer getGuruid() {
        return guruid;
    }

    public void setGuruid(Integer guruid) {
        this.guruid = guruid;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", insertimg='" + insertimg + '\'' +
                ", guruid=" + guruid +
                '}';
    }
}
