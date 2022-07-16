package com.semantro;

import com.semantro.number.Data;
import com.semantro.number.SemantroNumber;
import com.semantro.number.Type;
import org.junit.Assert;
import org.junit.Test;

public class MultiplicationTest {
    @Test
    public void multiplicationZeroTest() {
        SemantroNumber s1 = new SemantroNumber(new Data("0", "0"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("0", "0"), Type.BINARY);

        SemantroNumber result = s1.multiply(s2);

        Assert.assertEquals(result.getData().getFirst(), "0");
        Assert.assertEquals(result.getData().getLast(), "0");
    }

    @Test
    public void multiplicationUnitTest() {
        SemantroNumber s1 = new SemantroNumber(new Data("1", "1"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("1", "1"), Type.BINARY);

        SemantroNumber result = s1.multiply(s2);

        Assert.assertEquals(result.getData().getFirst(), "10");
        Assert.assertEquals(result.getData().getLast(), "01000000");
    }

    @Test
    public void multiplicationArbitraryTest1() {
        SemantroNumber s1 = new SemantroNumber(new Data("100", "0"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("0", "0"), Type.BINARY);

        SemantroNumber result = s1.multiply(s2);

        Assert.assertEquals(result.getData().getFirst(), "0");
        Assert.assertEquals(result.getData().getLast(), "0");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void multiplicationArbitraryTest2() {
        SemantroNumber s1 = new SemantroNumber(new Data("0", "0"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("100", "0"), Type.BINARY);

        SemantroNumber result = s1.multiply(s2);

        Assert.assertEquals(result.getData().getFirst(), "0");
        Assert.assertEquals(result.getData().getLast(), "0");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void multiplicationArbitraryTest3() {
        SemantroNumber s1 = new SemantroNumber(new Data("0", "100"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("0", "0"), Type.BINARY);

        SemantroNumber result = s1.multiply(s2);

        Assert.assertEquals(result.getData().getFirst(), "0");
        Assert.assertEquals(result.getData().getLast(), "0");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void multiplicationArbitraryTest4() {
        SemantroNumber s1 = new SemantroNumber(new Data("0", "0"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("0", "100"), Type.BINARY);

        SemantroNumber result = s1.multiply(s2);

        Assert.assertEquals(result.getData().getFirst(), "0");
        Assert.assertEquals(result.getData().getLast(), "0");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void multiplicationArbitraryTest5() {
        SemantroNumber s1 = new SemantroNumber(new Data("100", "1010"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("0", "0"), Type.BINARY);

        SemantroNumber result = s1.multiply(s2);

        Assert.assertEquals(result.getData().getFirst(), "0");
        Assert.assertEquals(result.getData().getFirst(), "0");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void multiplicationArbitraryTest6() {
        SemantroNumber s1 = new SemantroNumber(new Data("0", "0"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("100", "1010"), Type.BINARY);

        SemantroNumber result = s1.multiply(s2);

        Assert.assertEquals(result.getData().getFirst(), "0");
        Assert.assertEquals(result.getData().getFirst(), "0");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void multiplicationArbitraryTest7() {
        SemantroNumber s1 = new SemantroNumber(new Data("100", "1010"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("11", "0"), Type.BINARY);

        SemantroNumber result = s1.multiply(s2);

        Assert.assertEquals(result.getData().getFirst(), "1101");
        Assert.assertEquals(result.getData().getLast(), "11100000");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void multiplicationArbitraryTest8() {
        SemantroNumber s1 = new SemantroNumber(new Data("100", "1010"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("0", "1010"), Type.BINARY);

        SemantroNumber result = s1.multiply(s2);

        Assert.assertEquals(result.getData().getFirst(), "10");
        Assert.assertEquals(result.getData().getLast(), "11100100");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void multiplicationArbitraryTest9() {
        SemantroNumber s1 = new SemantroNumber(new Data("0", "1010"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("11", "1010"), Type.BINARY);

        SemantroNumber result = s1.multiply(s2);

        Assert.assertEquals(result.getData().getFirst(), "10");
        Assert.assertEquals(result.getData().getLast(), "01000100");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void multiplicationArbitraryTest10() {
        SemantroNumber s1 = new SemantroNumber(new Data("100", "0"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("11", "1010"), Type.BINARY);

        SemantroNumber result = s1.multiply(s2);

        Assert.assertEquals(result.getData().getFirst(), "1110");
        Assert.assertEquals(result.getData().getLast(), "10000000");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void multiplicationArbitraryTest11() {
        SemantroNumber s1 = new SemantroNumber(new Data("100", "1010"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("11", "1010"), Type.BINARY);

        SemantroNumber result = s1.multiply(s2);

        Assert.assertEquals(result.getData().getFirst(), "10000");
        Assert.assertEquals(result.getData().getLast(), "11000100");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void multiplicationNonBinaryTest() {
        SemantroNumber s1 = new SemantroNumber(new Data("4", "625"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("3", "625"), Type.BINARY);

        SemantroNumber result = s1.multiply(s2);

        Assert.assertNotEquals(result.getData().getFirst(), "10000");
        Assert.assertNotEquals(result.getData().getLast(), "11000100");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

}
