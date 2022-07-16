package com.semantro.number;

public class Binary {

    String text;

    public Binary(String text) {
        this.text = text;
    }

    public String toIntOfFirst() {
        try {
            return (new Data(text, "").decimalNumberOfFirst());
        } catch (Exception e) {
            return null;
        }
    }

    public double toIntOfLast() {
        try {
            return Double.parseDouble(new Data("", text).decimalNumberOfSecond());
        } catch (Exception e) {
            return 0;
        }
    }

    public static Binary of(String text) {
        return new Binary(text);
    }

}
