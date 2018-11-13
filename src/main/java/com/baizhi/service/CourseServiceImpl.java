package com.baizhi.service;

import com.baizhi.dao.CourseDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional

public class CourseServiceImpl implements  CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public void add(Course course) {
        courseDao.insert(course);
    }

    @Override
    public void remove(int id) {
        courseDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Course> findAll() {
        return courseDao.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Course> findByPage(Integer page, Integer rows) {
        int start =(page-1)*rows;
        return courseDao.queryByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return courseDao.queryTotals();
    }
}

