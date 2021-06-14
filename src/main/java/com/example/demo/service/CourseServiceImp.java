package com.example.demo.service;

import com.example.demo.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImp implements CourseService {

    List<Course> list;

    public CourseServiceImp() {

        list = new ArrayList<>();
        list.add(new Course(1, "Spring boot", "This course covers spring security, JWT, Thymeleaf, REST API's"));
        list.add(new Course(2, "Core Java", "This course covers  OOPS, Basic Java, Generics, Advance Java"));


    }

    public CourseServiceImp(List<Course> list) {
        this.list = list;
    }

    @Override
    public List<Course> getCourse() {
        return list;
    }

    @Override
    public Course getCoursesbyId(int id) {

       Course c = null;

       for(Course course : list){
           if(course.getId() == id){
               c = course;
               break;
           }
       }

       return c;

    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {

        for(Course course1 : list){
            if(course1.getId() == course.getId()){
                course1.setTitle(course1.getTitle());
                course1.setDescription(course1.getDescription());
            }

        }
        return course;
    }

    @Override
    public void deleteCourse(int id) {

        for(Course course: list){
            if(course.getId() == id){
                list.remove(course);
            }
        }



    }


}
