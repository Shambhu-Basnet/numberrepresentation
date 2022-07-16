package com.semantro;

import com.semantro.number.Data;
import com.semantro.number.SemantroNumber;
import com.semantro.number.Type;
import org.junit.Assert;
import org.junit.Test;

public class DivisionTest {
    @Test
    public void divisionTest1() {
        SemantroNumber s1 = new SemantroNumber(new Data("0", "0"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("100", "1010"), Type.BINARY);

        SemantroNumber result = s1.divide(s2);

        Assert.assertEquals(result.getData().getFirst(), "0");
        Assert.assertEquals(result.getData().getLast(), "0");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void divisionTest2() {
        SemantroNumber s1 = new SemantroNumber(new Data("1011", "0"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("100", "1010"), Type.BINARY);

        SemantroNumber result = s1.divide(s2);

        Assert.assertEquals(result.getData().getFirst(), "10");
        Assert.assertEquals(result.getData().getLast(), "01100000");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void divisionTest3() {
        SemantroNumber s1 = new SemantroNumber(new Data("0","1010"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("100","1010"), Type.BINARY);

        SemantroNumber result = s1.divide(s2);

        Assert.assertEquals(result.getData().getFirst(), "0");
        Assert.assertEquals(result.getData().getLast(), "00100010");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void divisionTest4() {
        SemantroNumber s1 = new SemantroNumber(new Data("100","1010"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("0","1010"), Type.BINARY);

        SemantroNumber result = s1.divide(s2);

        Assert.assertEquals(result.getData().getFirst(), "111");
        Assert.assertEquals(result.getData().getLast(), "01100110");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void divisionTest5() {
        SemantroNumber s1 = new SemantroNumber(new Data("1001","1010"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("100","0"), Type.BINARY);

        SemantroNumber result = s1.divide(s2);

        Assert.assertEquals(result.getData().getFirst(), "10");
        Assert.assertEquals(result.getData().getLast(), "01101000");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void divisionTest6() {
        SemantroNumber s1 = new SemantroNumber(new Data("1001","1010"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("100","1010"), Type.BINARY);

        SemantroNumber result = s1.divide(s2);

        Assert.assertEquals(result.getData().getFirst(), "10");
        Assert.assertEquals(result.getData().getLast(), "00010100");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void divisionUnitTest() {
        SemantroNumber s1 = new SemantroNumber(new Data("1","1"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("1","1"), Type.BINARY);

        SemantroNumber result = s1.divide(s2);

        Assert.assertEquals(result.getData().getFirst(), "1");
        Assert.assertEquals(result.getData().getLast(), "0");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void divisionUnitTest1() {
        SemantroNumber s1 = new SemantroNumber(new Data("110","111"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("0","0"), Type.BINARY);

        SemantroNumber result = s1.divide(s2);

        Assert.assertEquals(result.getData().getFirst(), "Infinity");
        Assert.assertEquals(result.getData().getLast(), "Infinity");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void divisionNonBinaryTest() {
        SemantroNumber s1 = new SemantroNumber(new Data("9","625"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("4","625"), Type.BINARY);

        SemantroNumber result = s1.divide(s2);

        Assert.assertNotEquals(result.getData().getFirst(), "10");
        Assert.assertNotEquals(result.getData().getLast(), "00010100");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }
}
