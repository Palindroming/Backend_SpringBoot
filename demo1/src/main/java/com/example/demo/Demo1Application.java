package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ anotation - 메타데이터, 전처리
@SpringBootApplication //mvc관련 api - frontcontroller, handlerMapping
public class Demo1Application {
    //여기서부터 프로그램이 동작~~
    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

}
