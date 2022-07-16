package com.semantro.app;

import com.semantro.number.Data;
import com.semantro.number.SemantroNumber;
import com.semantro.number.Type;

public class NumberApp {
    public static void main(String[] args) {
        SemantroNumber n1 = new SemantroNumber(new Data("1011", "1010"), Type.BINARY);
        SemantroNumber n2 = new SemantroNumber(new Data("1111", "1101"), Type.BINARY);

        SemantroNumber n3 = n1.add(n2);
        SemantroNumber n4 = n1.subtract(n2);
        SemantroNumber n5 = n1.multiply(n2);
        SemantroNumber n6 = n1.divide(n2);

        System.out.println("Addition: \n" + n3 + "\n");
        System.out.println("Subtraction: \n" + n4 + "\n");
        System.out.println("Multiplication: \n" + n5 + "\n");
        System.out.println("Division: \n" + n6 + "\n");
    }
}
