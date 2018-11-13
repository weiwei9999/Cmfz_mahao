package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public interface AdminService {

    public Admin findlogin(Admin admin);

    void motify (Admin admin);

    void  remove (int id);

     }
