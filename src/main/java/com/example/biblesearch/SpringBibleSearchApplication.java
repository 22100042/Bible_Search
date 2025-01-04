package com.example.biblesearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBibleSearchApplication extends SpringBootServletInitializer {

    // main 메서드 (개발 시, 내장 서버 테스트용)
    public static void main(String[] args) {
        SpringApplication.run(SpringBibleSearchApplication.class, args);
    }

    // 외부 톰캣에 배포 시, SpringBootServletInitializer 설정
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBibleSearchApplication.class);
    }
}
