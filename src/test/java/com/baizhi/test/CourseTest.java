package com.baizhi.test;


import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseTest extends  BasicTest{
    @Autowired
    private CourseService courseService;
@Test
    public void queryAll(){
        List<Course> c = courseService.findAll();
        for (Course course:c){
            System.out.println(course);
        }
    }
}
