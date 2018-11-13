package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/*
* 功课表
* */

public class Course {
    private Integer id;
    private String title;
    private String marking;

    @DateTimeFormat(pattern="yyyy-MM-dd" )
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date datetime;

    public Course() {
    }

    public Course(Integer id, String title, String marking, Date datetime) {
        this.id = id;
        this.title = title;
        this.marking = marking;
        this.datetime = datetime;
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

    public String getMarking() {
        return marking;
    }

    public void setMarking(String marking) {
        this.marking = marking;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", marking='" + marking + '\'' +
                ", datetime=" + datetime +
                '}';
    }
}
