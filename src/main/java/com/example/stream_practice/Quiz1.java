package com.example.stream_practice;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Quiz1 {

    private static final String TARGET = "좋아";
    // 1.1 각 취미를 선호하는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz1() throws IOException {
        List<String[]> csvLines = readCsvLines();
        return csvLines.stream()
                .map(line -> line[1].replaceAll("\\s","")) // 결과값으로 각 line의 2번째 요소들이 추출(ex 골프:야구)
                .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))// 괄호 안의 2차원 값을 1차원 스트림으로 변경시킨다. [[골프,야구], [스포츠댄스, 개발]] -> 1차원
                .collect(Collectors.toMap(hobby -> hobby, hobby -> 1, (oldValue, newValue) ->  newValue += oldValue));
    }

    // 1.2 각 취미를 선호하는 정씨 성을 갖는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz2() throws IOException {
        List<String[]> csvLines = readCsvLines();
        return csvLines.stream()
                .filter(line -> line[0].startsWith("정"))
                .map(line -> line[1].replaceAll("\\s", ""))
                .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
                .collect(Collectors.toMap(hobby -> hobby, hobby -> 1, (oldValue, newValue) -> ++newValue));
    }

    // 1.3 소개 내용에 '좋아'가 몇번 등장하는지 계산하여라.
    public int quiz3() throws IOException {
        List<String[]> csvLines = readCsvLines();
        return csvLines.stream()
                .map(line -> countContains(line[2], 0))
                .reduce(0, Integer::sum);
    }

    private int countContains(String src, int fromIndex){
        int index = src.indexOf(TARGET, fromIndex);
        if(index >= 0){
            return 1 + countContains(src, index + TARGET.length());
        }
        return 0;
    }

    private List<String[]> readCsvLines() throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        csvReader.readNext();
        return csvReader.readAll();
    }

}
