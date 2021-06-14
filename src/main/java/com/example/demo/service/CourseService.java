package com.example.demo.service;

import com.example.demo.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    public List<Course> getCourse();


    public Course getCoursesbyId(int id);

    public Course addCourse(Course course);

    public Course updateCourse(Course course);

    public void deleteCourse(int id);


}
