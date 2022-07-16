package com.semantro.number;

public class Decimal {
    String text;

    public Decimal(String text) {
        this.text = text;
    }

    public String toBinaryOfFirst() {
        try {
            return (new Data(text, "").binaryNumberOfFirst());
        }catch (Exception e) {
            return null;
        }
    }

    public String toBinaryOfLast() {
        try {
            return (new Data("", text).binaryNumberOfLast());
        }catch (Exception e) {
            return null;
        }
    }

    public static Decimal of(String text) {
        return new Decimal(text);
    }


}
