package com.baizhi.entity;

import java.util.List;
/*
* 上师类
* */
public class Guru {
    private Integer id;
    private String name;
    private String headpic;
    private String gender;
    private List<Article> articles;

    public Guru() {
    }

    public Guru(Integer id, String name, String headpic, String gender, List<Article> articles) {
        this.id = id;
        this.name = name;
        this.headpic = headpic;
        this.gender = gender;
        this.articles = articles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "GuruDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", headpic='" + headpic + '\'' +
                ", gender='" + gender + '\'' +
                ", articles=" + articles +
                '}';
    }
}
