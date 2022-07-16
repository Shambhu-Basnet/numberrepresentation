package com.semantro;

import com.semantro.number.Binary;
import com.semantro.number.Decimal;

public class BinaryTest {
    public static void main(String[] args) {

        System.out.println("Decimal number of First part: \n" + Binary.of("11011").toIntOfFirst());
        System.out.println("Decimal number of Second part: \n" + Binary.of("11011").toIntOfLast());
        System.out.println("Binary number of First part: \n" + Decimal.of("24").toBinaryOfFirst());
        System.out.println("Binary number of First part: \n" + Decimal.of("10").toBinaryOfLast());
    }
}
