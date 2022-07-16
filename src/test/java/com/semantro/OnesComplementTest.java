package com.semantro;

import com.semantro.number.Data;

public class OnesComplementTest {
    public static void main(String[] args) {
        Data d1 = new Data("111", "000");
        System.out.println(d1.onesComplementOf());
    }
}
