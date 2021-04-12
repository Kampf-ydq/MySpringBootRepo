package com.neu.honeypot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.neu.honeypot.mapper")//扫描mapper
public class HoneypotApplication {

    public static void main(String[] args) {
        SpringApplication.run(HoneypotApplication.class, args);
    }

}
