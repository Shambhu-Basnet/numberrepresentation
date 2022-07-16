package com.semantro;

import com.semantro.number.Data;
import com.semantro.number.SemantroNumber;
import com.semantro.number.Type;
import org.junit.Assert;
import org.junit.Test;

public class AdditionTest {

    @Test
    public void additionArbitraryTest() {
        SemantroNumber s1 = new SemantroNumber(new Data("1101", "1011"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("11", "1011"), Type.BINARY);

        SemantroNumber result = s1.add(s2);

        Assert.assertEquals(result.getData().getFirst(), "10001");
        Assert.assertEquals(result.getData().getLast(), "0110");
        Assert.assertEquals(result.getType(), Type.BINARY);
        Assert.assertNotSame(result.getData().getFirst(), s1.getData().getFirst());
        Assert.assertNotEquals(result.getData(), s1.getData());
        Assert.assertNotSame(result.getData(), s1.getData());
    }

    @Test
    public void additionZeroTest() {
        SemantroNumber s1 = new SemantroNumber(new Data("0", "0"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("0", "0"), Type.BINARY);

        SemantroNumber result = s1.add(s2);

        Assert.assertEquals(result.getData().getFirst(), "0");
        Assert.assertEquals(result.getData().getLast(), "0");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void additionUnitTest() {
        SemantroNumber s1 = new SemantroNumber(new Data("1","1"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("1","1"), Type.BINARY);

        SemantroNumber result = s1.add(s2);

        Assert.assertEquals(result.getData().getFirst(), "11");
        Assert.assertEquals(result.getData().getLast(), "0");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void additionArbitraryTest1() {
        SemantroNumber s1 = new SemantroNumber(new Data("1101", "1011"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("0", "1011"), Type.BINARY);

        SemantroNumber result = s1.add(s2);

        Assert.assertEquals(result.getData().getFirst(), "1110");
        Assert.assertEquals(result.getData().getLast(), "0110");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void additionArbitraryTest2() {
        SemantroNumber s1 = new SemantroNumber(new Data("1101", "1011"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("111", "0"), Type.BINARY);

        SemantroNumber result = s1.add(s2);

        Assert.assertEquals(result.getData().getFirst(), "10100");
        Assert.assertEquals(result.getData().getLast(), "1011");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void additionArbitraryTest3() {
        SemantroNumber s1 = new SemantroNumber(new Data("0", "1011"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("1101", "1011"), Type.BINARY);

        SemantroNumber result = s1.add(s2);

        Assert.assertEquals(result.getData().getFirst(), "1110");
        Assert.assertEquals(result.getData().getLast(), "0110");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void additionArbitraryTest4() {
        SemantroNumber s1 = new SemantroNumber(new Data("1101", "0"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("1101", "1011"), Type.BINARY);

        SemantroNumber result = s1.add(s2);

        Assert.assertEquals(result.getData().getFirst(), "11010");
        Assert.assertEquals(result.getData().getLast(), "1011");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void additionArbitraryTest5() {
        SemantroNumber s1 = new SemantroNumber(new Data("1101", "1011"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("0", "0"), Type.BINARY);

        SemantroNumber result = s1.add(s2);

        Assert.assertEquals(result.getData().getFirst(), "1101");
        Assert.assertEquals(result.getData().getLast(), "1011");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void additionArbitraryTest6() {
        SemantroNumber s1 = new SemantroNumber(new Data("0", "0"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("1011", "1100"), Type.BINARY);

        SemantroNumber result = s1.add(s2);

        Assert.assertEquals(result.getData().getFirst(), "1011");
        Assert.assertEquals(result.getData().getLast(), "1100");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void additionNonBinaryTest() {
        SemantroNumber s1 = new SemantroNumber(new Data("13", "6875"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("3", "6875"), Type.BINARY);

        SemantroNumber result = s1.add(s2);

        Assert.assertNotEquals(result.getData().getFirst(), "10001");
        Assert.assertNotEquals(result.getData().getLast(), "0110");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

}
