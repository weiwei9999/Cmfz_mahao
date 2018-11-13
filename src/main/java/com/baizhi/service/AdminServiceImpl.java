package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service()
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin findlogin(Admin admin) {
        return adminDao.query(admin);
    }

    @Override
    public void motify(Admin admin) {
        adminDao.update(admin);
    }

    @Override
    public void remove(int id) {
         adminDao.delete(id);
    }
}
