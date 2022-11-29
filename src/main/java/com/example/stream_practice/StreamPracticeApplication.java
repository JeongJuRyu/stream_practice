package com.example.stream_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class StreamPracticeApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(StreamPracticeApplication.class, args);
        Quiz1 quiz1 = new Quiz1();
        quiz1.quiz1();
    }

}
