package com.semantro;

import com.semantro.number.PaddedPair;
import com.semantro.number.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PaddedDataTest {
    public static void main(String[] args) {
        List<Character> firstList = new ArrayList<>();
        List<Character> secondList = new ArrayList<>();

        firstList.add('1');
        firstList.add('1');
        firstList.add('1');
        firstList.add('1');

        secondList.add('1');
        secondList.add('1');

        String s1 = firstList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        String s2 = secondList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        PaddedPair p1 = (StringUtils.paddedDataAtFirst(s1, s2));
        PaddedPair p2 = (StringUtils.paddedDataAtLast(s2, s1));

        System.out.println("Padded Data at first: \n" + p1);
        System.out.println("Padded Data at last: \n" + p2);
    }
}
