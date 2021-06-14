package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses" )
    @CrossOrigin(origins = "http://localhost:8080")
    public List<Course> getCourse(){
        return courseService.getCourse();
    }

    @GetMapping("/courses/{id}")
    public Course getCoursebyId(@PathVariable String id){

        return courseService.getCoursesbyId(Integer.parseInt(id));
    }

    @PostMapping(value = "/courses", consumes = "application/json")
    public Course addCourses( @RequestBody Course course){

        return courseService.addCourse(course);


    }

    @PutMapping(value = "/courses")
    public Course updateCourses( @RequestBody Course course){

        return courseService.updateCourse(course);


    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<HttpStatus> deleteCourses(@PathVariable String id ){

        try{

            courseService.deleteCourse(Integer.parseInt(id));
            return new ResponseEntity<>(HttpStatus.OK);

        }
        catch (Exception e){

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);


        }


    }
}
