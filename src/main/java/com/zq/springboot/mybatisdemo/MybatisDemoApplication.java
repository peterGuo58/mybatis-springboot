package com.zq.springboot.mybatisdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zq.springboot.mybatisdemo.mapper")
public class MybatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }

}

