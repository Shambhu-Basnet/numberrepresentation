package com.semantro.app;

import com.semantro.number.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OnesComplementTest {
    public static void main(String[] args) {
        String string1 = "";
        String string2 = "";

        System.out.println(stringComparison(string1, string2));
        System.out.println(onesComplementOf(string1));
        System.out.println(isGreaterThan(string1, string2));
    }

    public static String onesComplementOf(String number) {
        if(number.equals(GlobalLiterals.EMPTY)){
            return number;
        }else {
            return number.chars()
                    .map(ch -> ch == '0' ? '1' : '0')
                    .mapToObj(i -> String.valueOf((char) i))
                    .collect(Collectors.joining(""));
        }
    }

    public static String stringComparison(String number1, String number2) {
        if (number1.equals(GlobalLiterals.EMPTY) && number2.equals(GlobalLiterals.EMPTY)) {
            return number1;
        }else if (number1.equals(GlobalLiterals.EMPTY)){
            return number2;
        }else if (number2.equals(GlobalLiterals.EMPTY)){
            return number1;
        } else {
            PaddedPair p1 = StringUtils.paddedDataAtFirst(number1, number2);
            for (int index = 0; index < p1.getFirstResult().size(); index++) {
                if (p1.getFirstResult().get(index) == '1' && p1.getSecondResult().get(index) == '0') return number1;
                else if (p1.getFirstResult().get(index) == '0' && p1.getSecondResult().get(index) == '1') return number2;
            }
            return number1;
        }
    }

    public static boolean isGreaterThan(String s1, String s2) {
        PaddedPair p1 = StringUtils.paddedDataAtFirst(s1, s2);
        for (int index = 0; index < p1.getFirstResult().size(); index++) {
            if (p1.getFirstResult().get(index) == '1' && p1.getSecondResult().get(index) == '0') return true;
            else if (p1.getFirstResult().get(index) == '0' && p1.getSecondResult().get(index) == '1') return false;
        }
        return false;
    }
}
