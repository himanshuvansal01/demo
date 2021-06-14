package com.example.demo;

import com.example.demo.model.Course;
import com.example.demo.service.CourseServiceImp;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class MockitoCourseTest {



    @Autowired
    private CourseServiceImp courseServiceImp;

    @Autowired
    private Course course;

    @Autowired
    private OrderService orderService;


    @Test
    public void courseId(){
        Mockito.when(courseServiceImp.getCourse()).thenReturn(courseServiceImp.getCourse());
        List<Course> testName = orderService.getProductName();
        Assert.assertEquals(courseServiceImp.getCourse(), testName);

    }
}
