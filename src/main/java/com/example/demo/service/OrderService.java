package com.example.demo.service;

import com.example.demo.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    CourseServiceImp courseServiceImp;

    public OrderService(CourseServiceImp courseServiceImp) {
        this.courseServiceImp = courseServiceImp;
    }

    public List<Course> getProductName(){
        return courseServiceImp.getCourse();
    }
}
