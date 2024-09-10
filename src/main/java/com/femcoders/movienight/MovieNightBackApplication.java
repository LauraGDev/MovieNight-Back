package com.femcoders.movienight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MovieNightBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieNightBackApplication.class, args);
    }
}
