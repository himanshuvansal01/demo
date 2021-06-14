package com.example.demo;

import com.example.demo.service.CourseServiceImp;
import com.example.demo.service.ProductService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class ProductConfiguration {

    @Bean
    @Primary
    public CourseServiceImp courseServiceImp(){
        return Mockito.mock(CourseServiceImp.class);
    }


}
