package com.semantro;

import com.semantro.number.RationalNumber;

public class RationalTest {
    public static void main(String[] args) {
        RationalNumber number1 = RationalNumber.empty().setNumerator(2).setDenominator(4);
        RationalNumber number2 = RationalNumber.empty().setNumerator(3).setDenominator(2);
        RationalNumber n1 = new RationalNumber();
        System.out.println(n1.toFraction(0.6875));

        System.out.println(number1);
        System.out.println(number1.add(number2));
        System.out.println(number1.subtract(number2));
        System.out.println(number1.multiply(number2));
        System.out.println(number1.divide(number2));
        System.out.println();
    }


}
