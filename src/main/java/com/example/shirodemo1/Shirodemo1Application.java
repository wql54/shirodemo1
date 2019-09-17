package com.example.shirodemo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.shirodemo1.dao")
public class Shirodemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Shirodemo1Application.class, args);
    }

}
