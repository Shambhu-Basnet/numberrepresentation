package com.semantro.number;

public class RationalNumber {
    int numerator;
    int denominator;

    public RationalNumber() {
//        this.numerator = 0;
//        this.denominator = 1;
        this(0, 1);
    }

    public RationalNumber(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public RationalNumber setNumerator(int numerator) {
        return new RationalNumber(numerator, this.denominator);
    }

    public int getDenominator() {
        return denominator;
    }

    public RationalNumber setDenominator(int denominator) {
        return new RationalNumber(this.numerator, denominator);
    }

    @Override
    public String toString() {
        return "RationalNumber{" +
                "numerator= " + numerator +
                ", denominator= " + denominator +
                '}';
    }

    public static RationalNumber empty() {
        return new RationalNumber();
    }

    public int gcd(int number1, int number2) {
        if (number1 == 0) return number2;
        else if (number2 == 0) return number1;
        else if (number1 == number2) return number1;
        else if (number1 > number2) return gcd(number1 - number2, number2);
        else return gcd(number2, number2 - number1);
    }

    public int lcm(int number1, int number2) {
        return (number1 * number2) / gcd(number1, number2);
    }

    public RationalNumber add(RationalNumber other) {
        RationalNumber result = new RationalNumber();
        result.denominator = lcm(this.denominator, other.denominator);
        result.numerator = this.numerator * (result.denominator / this.denominator) + other.numerator * (result.denominator / other.denominator);

        return reduce(result.numerator, result.denominator);
    }

    public RationalNumber subtract(RationalNumber other) {
        RationalNumber result = new RationalNumber();
        result.denominator = lcm(this.denominator, other.denominator);
        result.numerator = this.numerator * (result.denominator / this.denominator) - other.numerator * (result.denominator / other.denominator);

        return reduce(result.numerator, result.denominator);
    }

    public RationalNumber multiply(RationalNumber other) {
        RationalNumber result = new RationalNumber();
        result.numerator = this.numerator * other.numerator;
        result.denominator = this.denominator * other.denominator;

        return reduce(result.numerator, result.denominator);
    }

    public RationalNumber divide(RationalNumber other) {
        RationalNumber result = new RationalNumber();
        result.numerator = this.numerator * other.denominator;
        result.denominator = this.denominator * other.numerator;

        return reduce(result.numerator, result.denominator);
    }

    public RationalNumber reduce(int number1, int number2) {
        int gcdNumber = gcd(number1, number2);
        return new RationalNumber(number1 / gcdNumber, number2 / gcdNumber);
    }

    public RationalNumber toFraction(double number) {
        String string = String.valueOf(number);
        String[] splits = string.split("[.]");
        int afterDecimalPoint = splits[1].length();
        int denominator = (int) Math.pow(10, afterDecimalPoint);
        int numerator = (int) (number * denominator);

        return reduce(numerator, denominator);
    }
}
