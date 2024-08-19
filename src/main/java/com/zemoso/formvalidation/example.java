package com.zemoso.formvalidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class example {
    public static void main(String[] args) {
        String [] stringArray = {
                "nikhil",
                "rahul",
                "rohan",
                "ankit",
                "sai",
                "hello"
        };

        List<String> answer = Arrays.asList(stringArray).stream().map(String -> String.toUpperCase()).sorted().collect(Collectors.toList());

        System.out.println(answer);
    }
}
