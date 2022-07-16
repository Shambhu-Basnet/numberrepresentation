package com.semantro.app;

import java.util.ArrayList;
import java.util.List;

public class Reverse {
    public static void main(String[] args){
        System.out.println(reverseString("1234"));
    }

    public static String reverseString(String str){
        List<String> s1 = new ArrayList<>();
        for(int i = str.length()-1; i>=0 ; i--) {
            s1.add(String.valueOf(str.charAt(i)));
        }
        return String.join("", s1);
    }
}
