package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import com.example.demo.service.CourseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class CourseWebController {

    @Autowired
    private CourseServiceImp courseServiceImp;

    //Get all the courses
    @RequestMapping("/course")
    public String getHomepage(Model model){

        model.addAttribute("greetings", this.courseServiceImp.getCourse());

        return "index";
    }

    //Get all the new Courses
    @RequestMapping(value = "/addcourse" , method = RequestMethod.GET)
    public String addcourse(@ModelAttribute("course") Course course, Model model){

        model.addAttribute("greetings", this.courseServiceImp.getCourse());

        return "addcourse";
    }

    //Post all the new Courses
    @RequestMapping(value = "/course/addcourse" , method = RequestMethod.POST)
    public String postcourse(@ModelAttribute("course") Course course1, Model model){

        courseServiceImp.addCourse(course1);

        model.addAttribute("greetings", this.courseServiceImp.getCourse());

        return "addcourse";
    }

    //Delete the courses
    @RequestMapping(value = "/course/DeleteCourse/{id}" , method = RequestMethod.POST)
    public String postDeletecourse(@PathVariable String id, @ModelAttribute("delete") Course course1, Model model){

        courseServiceImp.deleteCourse(Integer.parseInt(id));

        model.addAttribute("greetings", this.courseServiceImp.getCourse());

        return "DeleteCourse";
    }

    // Get the course
    @RequestMapping(value = "/course/DeleteCourse" , method = RequestMethod.GET)
    public String getDeletecourse( @ModelAttribute("delete") Course course1, Model model){

        model.addAttribute("greetings", this.courseServiceImp.getCourse());

        return "DeleteCourse";
    }


}
