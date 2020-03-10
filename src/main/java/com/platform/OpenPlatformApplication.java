package com.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.platform.dao")
@SpringBootApplication
public class OpenPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenPlatformApplication.class, args);
    }

}
