package com.avi.dashBoard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class DashBoardApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DashBoardApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // Here you specify the main application class
        return application.sources(DashBoardApplication.class);
    }
}

