package com.semantro.number;

import java.util.List;

public class PaddedPair {
    List<Character> firstResult;
    List<Character> secondResult;

    public PaddedPair(List<Character> firstResult, List<Character> secondResult) {
        this.firstResult = firstResult;
        this.secondResult = secondResult;
    }

    public List<Character> getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(List<Character> firstResult) {
        this.firstResult = firstResult;
    }

    public List<Character> getSecondResult() {
        return secondResult;
    }

    public void setSecondResult(List<Character> secondResult) {
        this.secondResult = secondResult;
    }

    @Override
    public String toString() {
        return "PaddedPair1{" +
                "firstResult=" + firstResult +
                ", secondResult=" + secondResult +
                '}';
    }
}
