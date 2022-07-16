package com.semantro;

import com.semantro.number.Data;
import com.semantro.number.SemantroNumber;
import com.semantro.number.Type;
import org.classpath.icedtea.pulseaudio.PulseAudioMixer;
import org.junit.Assert;
import org.junit.Test;

public class SubtractionTest {

    @Test
    public void subtractionZeroTest() {
        SemantroNumber s1 = new SemantroNumber(new Data("0", "0"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("0", "0"), Type.BINARY);

        SemantroNumber result = s1.subtract(s2);

        Assert.assertEquals(result.getData().getFirst(), "0");
        Assert.assertEquals(result.getData().getLast(), "0");
        Assert.assertEquals(result.getType(), Type.BINARY);

    }

    @Test
    public void subtractionUnitTest() {
        SemantroNumber s1 = new SemantroNumber(new Data("1", "1"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("1", "1"), Type.BINARY);

        SemantroNumber result = s1.subtract(s2);

        Assert.assertEquals(result.getData().getFirst(), "0");
        Assert.assertEquals(result.getData().getLast(), "0");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void subtractionArbitraryTest1() {
        SemantroNumber s1 = new SemantroNumber(new Data("1111", "1010"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("1000", "1111"), Type.BINARY);

        SemantroNumber result = s1.subtract(s2);

        Assert.assertEquals(result.getData().getFirst(), "0110");
        Assert.assertEquals(result.getData().getLast(), "1011");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void subtractionArbitraryTest2() {
        SemantroNumber s1 = new SemantroNumber(new Data("1000", "1111"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("1111", "1010"), Type.BINARY);

        SemantroNumber result = s1.subtract(s2);

        Assert.assertEquals(result.getData().getFirst(), "0110");
        Assert.assertEquals(result.getData().getLast(), "1011");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void subtractionArbitraryTest3() {
        SemantroNumber s1 = new SemantroNumber(new Data("0", "1111"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("1111", "1010"), Type.BINARY);

        SemantroNumber result = s1.subtract(s2);

        Assert.assertEquals(result.getData().getFirst(), "1110");
        Assert.assertEquals(result.getData().getLast(), "1011");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void subtractionArbitraryTest4() {
        SemantroNumber s1 = new SemantroNumber(new Data("1000", "0"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("1111", "1010"), Type.BINARY);

        SemantroNumber result = s1.subtract(s2);

        Assert.assertEquals(result.getData().getFirst(), "0111");
        Assert.assertEquals(result.getData().getLast(), "1010");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void subtractionArbitraryTest5() {
        SemantroNumber s1 = new SemantroNumber(new Data("1000", "1011"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("0", "1010"), Type.BINARY);

        SemantroNumber result = s1.subtract(s2);

        Assert.assertEquals(result.getData().getFirst(), "1000");
        Assert.assertEquals(result.getData().getLast(), "0001");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void subtractionArbitraryTest6() {
        SemantroNumber s1 = new SemantroNumber(new Data("1000", "1011"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("1111", "0"), Type.BINARY);

        SemantroNumber result = s1.subtract(s2);

        Assert.assertEquals(result.getData().getFirst(), "0110");
        Assert.assertEquals(result.getData().getLast(), "0101");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void subtractionArbitraryTest7() {
        SemantroNumber s1 = new SemantroNumber(new Data("0", "1011"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("1111", "0"), Type.BINARY);

        SemantroNumber result = s1.subtract(s2);

        Assert.assertEquals(result.getData().getFirst(), "1110");
        Assert.assertEquals(result.getData().getLast(), "0101");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void subtractionArbitraryTest8() {
        SemantroNumber s1 = new SemantroNumber(new Data("1000", ""), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("", "1010"), Type.BINARY);

        SemantroNumber result = s1.subtract(s2);

        Assert.assertEquals(result.getData().getFirst(), "0111");
        Assert.assertEquals(result.getData().getLast(), "0110");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void subtractionArbitraryTest9() {
        SemantroNumber s1 = new SemantroNumber(new Data("1000", "0"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("1101", "0"), Type.BINARY);

        SemantroNumber result = s1.subtract(s2);

        Assert.assertEquals(result.getData().getFirst(), "0101");
        Assert.assertEquals(result.getData().getLast(), "0");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void subtractionArbitraryTest10() {
        SemantroNumber s1 = new SemantroNumber(new Data("0", "1000"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("0", "1101"), Type.BINARY);

        SemantroNumber result = s1.subtract(s2);

        Assert.assertEquals(result.getData().getFirst(), "0");
        Assert.assertEquals(result.getData().getLast(), "0101");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }

    @Test
    public void subtractionNonBinaryTest() {
        SemantroNumber s1 = new SemantroNumber(new Data("8", "9375"), Type.BINARY);
        SemantroNumber s2 = new SemantroNumber(new Data("15", "625"), Type.BINARY);

        SemantroNumber result = s1.subtract(s2);

        Assert.assertNotEquals(result.getData().getFirst(), "0110");
        Assert.assertNotEquals(result.getData().getLast(), "1011");
        Assert.assertEquals(result.getType(), Type.BINARY);
    }
}
