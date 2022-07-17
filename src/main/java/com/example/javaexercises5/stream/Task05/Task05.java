package com.example.javaexercises5.stream.Task05;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task05 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("ławka", "długopis", "rama", "artur", "menda");

        Map<String, String> map = strings.stream()
                .collect(Collectors.toMap(w -> w, StringUtils::reverse));

        System.out.println(map);
    }
}
