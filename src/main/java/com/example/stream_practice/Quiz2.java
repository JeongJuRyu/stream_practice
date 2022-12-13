package com.example.stream_practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Quiz2 {
    private static List<String> words = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    // 2.1 List에 저장된 단어들의 접두사가 각각 몇개씩 있는지 Map<String, Integer>으로 변환하여라.
    // ex) ("T", 1), ("a", 2) ...

    public Map<String, Integer> quiz1(){
        return words.stream().map(s -> s.substring(0,1))
                .collect(Collectors.toMap(s -> s, s -> 1, (oldValue, newValue) -> newValue += oldValue));
    }
}
