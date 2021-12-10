package com.javacourse.demospringbootstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javacourse.demo.School;

@SpringBootApplication
public class DemoSpringBootStarterApplication implements CommandLineRunner {

    @Autowired
    private School school;

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootStarterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String message = school.msg();
        System.out.println(message);
    }
}
