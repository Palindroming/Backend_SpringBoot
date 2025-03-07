package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    public TestConfig(){
        System.out.println("TestConfig");
    }

    @Bean
    public MyBean myBean(){
        return new MyBean();
    }
}
