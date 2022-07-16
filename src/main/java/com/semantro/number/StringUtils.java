package com.semantro.number;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    public static PaddedPair paddedDataAtFirst(String string1, String string2){
        List<Character> firstList1 = toCharList(string1);
        List<Character> firstList2 = toCharList(string2);
        if (firstList1.size() < firstList2.size()) {
            int difference = firstList2.size() - firstList1.size();
            for (int i = 0; i < difference; i++) firstList1.add(0, GlobalLiterals.CHARACTER_ZERO);
        } else {
            int difference = firstList1.size() - firstList2.size();
            for (int i = 0; i < difference; i++) firstList2.add(0, GlobalLiterals.CHARACTER_ZERO);
        }

        return new PaddedPair(firstList1, firstList2);

    }

    public static PaddedPair paddedDataAtLast(String string1, String string2){
        List<Character> firstList1 = toCharList(string1);
        List<Character> firstList2 = toCharList(string2);
        if (firstList1.size() < firstList2.size()) {
            int difference = firstList2.size() - firstList1.size();
            for (int i = 0; i < difference; i++) firstList1.add(GlobalLiterals.CHARACTER_ZERO);
        } else {
            int difference = firstList1.size() - firstList2.size();
            for (int i = 0; i < difference; i++) firstList2.add(GlobalLiterals.CHARACTER_ZERO);
        }

        return new PaddedPair(firstList1, firstList2);

    }

    private static List<Character> toCharList(String str) {
        List<Character> result = new ArrayList<>();
        for (char ch : str.toCharArray()) result.add(ch);
        return result;
    }

    public static boolean isGreaterThan(String s1, String s2) {
        PaddedPair p1 = StringUtils.paddedDataAtFirst(s1, s2);
        for (int index = 0; index < p1.getFirstResult().size(); index++) {
            if (p1.getFirstResult().get(index) == '1' && p1.getSecondResult().get(index) == '0') return true;
            else if (p1.getFirstResult().get(index) == '0' && p1.getSecondResult().get(index) == '1') return false;
        }
        return false;
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

    public static String stringSplit(String number) {
        String string = String.valueOf(number);
        String[] splits = string.split("[.]");

        return splits[1];
    }

}
