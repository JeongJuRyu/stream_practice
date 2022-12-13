package com.example.stream_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Map;

@SpringBootApplication
public class StreamPracticeApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(StreamPracticeApplication.class, args);
//        Quiz1 quiz1 = new Quiz1();
//        Map<String, Integer> answer = quiz1.quiz1();
//
//        for(String key : answer.keySet()){
//            System.out.println(key + " : " + answer.get(key));
//        }
//        answer = quiz1.quiz2();
//        for(String key : answer.keySet()){
//            System.out.println(key + " : " + answer.get(key));
//        }
//
//        int quiz3Answer = quiz1.quiz3();
//        System.out.println(quiz3Answer);

        Quiz2 quiz2 = new Quiz2();
        System.out.println(quiz2.quiz1());
    }
}
