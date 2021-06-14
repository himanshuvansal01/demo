package com.example.demo.controller;

import com.example.demo.model.AuthenticationRequest;
import com.example.demo.model.AuthenticationResponse;
import com.example.demo.model.Course;

import com.example.demo.service.CourseService;
import com.example.demo.service.CourseServiceImp;
import com.example.demo.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseWebController {

    @Autowired
    private CourseServiceImp courseServiceImp;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwUtil jwtTokenUtil;






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
    @RequestMapping(value = "/course/DeleteCourse" , method = RequestMethod.POST)
    public String postDeletecourse( @ModelAttribute("delete") Course course1, Model model){

        courseServiceImp.deleteCourse(course1.getId());

        model.addAttribute("greetings", this.courseServiceImp.getCourse());

        return "index";
    }

    // Get the course
    @RequestMapping(value = "/course/DeleteCourse" , method = RequestMethod.GET)
    public String getDeletecourse( @ModelAttribute("delete") Course course1, Model model){

        model.addAttribute("delete", new Course());

        return "DeleteCourse";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthentication(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);

        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());


        final String jwt  = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));




    }


}
