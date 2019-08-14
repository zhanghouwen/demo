package com.example.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@ImportResource("classpath:dubbo.xml")
@SpringBootApplication()
public class Demo2Application {
   
    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }



}
