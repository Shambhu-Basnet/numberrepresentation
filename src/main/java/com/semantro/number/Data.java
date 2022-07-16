package com.semantro.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class represents first and second part of
 * a number separated by a decimal point.
 */
public class Data {
    String first;
    String last;

    /**
     * Default constructor, initializes the before and
     * after decimal part of a number.
     * A number can be without a decimal place, in that case
     * before decimal value could be an empty string.
     *
     * @param first
     * @param last
     */
    public Data(String first, String last) {
        this.first = first.trim();
        this.last = last.trim();
    }

    public boolean hasBoth() {
        return !this.first.isEmpty() && !this.last.isEmpty();
    }

    public boolean hasFirst() {
        return !this.first.isEmpty() && this.last.isEmpty();
    }

    public boolean hasLast() {
        return this.first.isEmpty() && !this.last.isEmpty();
    }


    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String binaryNumberOfFirst() {
        if (this.first.equals("0")) {
            return "0";
        } else {
            StringBuilder s = new StringBuilder();
            for (int firstNumber = Integer.parseInt(this.first); firstNumber > 0; firstNumber /= 2)
                s.append(firstNumber % GlobalLiterals.TWO);

            return String.valueOf(s.reverse());
        }

    }

    public String binaryNumberOfLast() {
        if (this.last.equals("0")) {
            return "0";
        } else {
            StringBuilder resultBuilder = new StringBuilder();
            Long result = Long.parseLong(this.last);
            for (int index = GlobalLiterals.ZERO; index < GlobalLiterals.MAX_DECIMAL; index++) {
                result = result * GlobalLiterals.TWO;
                String resultStr = String.valueOf(result);
                if (resultStr.length() > last.length()) {
                    resultBuilder.append(GlobalLiterals.ONE);
                    String s1 = String.valueOf(result);
                    result = Long.parseLong(s1.substring(GlobalLiterals.ONE));
                } else {
                    resultBuilder.append(GlobalLiterals.ZERO);
                }
            }
            return resultBuilder.toString();
        }
    }

    public String decimalNumberOfFirst() {
        String binaryNumber = this.first;
        char[] bn = binaryNumber.toCharArray();
        int dn = 0;
        int power = bn.length - 1;
        for (char c : bn) {
            int ch = Integer.parseInt(String.valueOf(c));
            dn = (int) (dn + Integer.parseInt(String.valueOf(ch)) * (Math.pow(2, power)));
            power--;
        }
        return String.valueOf(dn);
    }

    public String decimalNumberOfSecond() {
        char[] bn = this.last.toCharArray();
        double dn = 0;
        int power = 1;
        for (char c : bn) {
            int ch = Integer.parseInt(String.valueOf(c));
            dn = (dn + Integer.parseInt(String.valueOf(ch)) * (Math.pow(2, -power)));
            power++;
        }
        return String.valueOf(dn);
    }

    public boolean isEmpty() {
        return this.first.isEmpty() && this.last.isEmpty();
    }

    public boolean isZero() {
        return this.first.equals("0") && this.last.equals("0");
    }

    public Data getBinary() {
        return new Data(this.binaryNumberOfFirst(), this.binaryNumberOfLast());
    }

    public Data add(Data other) {
        if (this.isEmpty()) return other;
        else if (other.isEmpty()) return this;
        else if (this.hasBoth() && other.hasBoth()) return addBoth(other);
        else if (this.hasFirst() && other.hasBoth()) return addFirstBoth(other);
        else if (this.hasLast() && other.hasBoth()) return addLastBoth(other);
        else if (this.hasBoth() && other.hasFirst()) return addBothFirst(other);
        else if (this.hasFirst() && other.hasFirst()) return addFirstFirst(other);
        else if (this.hasBoth() && other.hasLast()) return addBothLast(other);
        else if (this.hasFirst() && other.hasLast()) return addFirstLast(other);
        else if (this.hasLast() && other.hasFirst()) return addLastFirst(other);
        else return addLastLast(other);
    }

    private Data addLastFirst(Data other) {
        return new Data(other.first, this.last);
    }

    private Data addFirstLast(Data other) {
        return new Data(this.first, other.last);
    }

    private Data addBothLast(Data other) {
        Result result = addLastLastUtils(other);
        if (result.hasCarry()) {
            Data carryData = new Data(result.getCarry(), GlobalLiterals.EMPTY);
            Data firstSum = carryData.addFirstFirst(this);
            return new Data(firstSum.getFirst(), result.getValue());
        } else {
            return new Data(this.getFirst(), result.getValue());
        }
    }

    private Data addLastBoth(Data other) {
        return other.addBothLast(this);
    }

    private Data addBoth(Data other) {
        Result result = addLastLastUtils(other);
        Data firstSum = addFirstFirst(other);
        if (result.hasCarry()) {
            Data firstWithCarry = firstSum.addFirstFirst(new Data(result.getCarry(), GlobalLiterals.EMPTY));
            return new Data(firstWithCarry.getFirst(), result.getValue());
        } else {
            return new Data(firstSum.getFirst(), result.getValue());
        }
    }

    private Data addFirstBoth(Data other) {
        Data firstSum = addFirstFirst(other);
        return new Data(firstSum.getFirst(), other.getLast());
    }

    private Data addBothFirst(Data other) {
        Data firstSum = addFirstFirst(other);
        return new Data(firstSum.getFirst(), this.getLast());
    }

    private Data addFirstFirst(Data other) {
        PaddedPair p1 = (StringUtils.paddedDataAtFirst(this.first, other.first));

        List<Pair> pairedCharacters = combinedList(p1.getFirstResult(), p1.getSecondResult());
        List<Character> result = new ArrayList<>();
        char carry = '0';
        for (int i = pairedCharacters.size() - 1; i >= 0; i--) {
            Pair tResult = addBinary(pairedCharacters.get(i));
            if (carry == '1') {
                if (tResult.hasCarry()) result.add('1');
                else {
                    Pair cAdd = addBinary(new Pair(carry, tResult.getY()));
                    carry = cAdd.getX();
                    result.add(cAdd.getY());
                }
            } else {
                result.add(tResult.getY());
                carry = tResult.getX();
            }
        }

        if (carry == '1') result.add(carry);
        Collections.reverse(result);
        StringBuilder resultBuilder = new StringBuilder();
        for (char ch : result) resultBuilder.append(ch);

        return new Data(resultBuilder.toString(), GlobalLiterals.EMPTY);
    }

    private Pair addBinary(Pair item) {
        if (item.x == '1' && item.y == '1') return new Pair('1', '0');
        else if (item.x == '1' && item.y == '0') return new Pair('0', '1');
        else if (item.x == '0' && item.y == '1') return new Pair('0', '1');
        else return new Pair('0', '0');
    }

    private List<Pair> combinedList(List<Character> firstList, List<Character> lastList) {
        return IntStream
                .range(0, lastList.size())
                .mapToObj(i -> new Pair(firstList.get(i), lastList.get(i)))
                .collect(Collectors.toList());
    }

    private Data addLastLast(Data other) {
        Result result = addLastLastUtils(other);
        return new Data(result.getCarry(), result.getValue());
    }

    private Result addLastLastUtils(Data other) {
        PaddedPair p1 = (StringUtils.paddedDataAtLast(this.last, other.last));

        List<Pair> pairedCharacters = combinedList(p1.getFirstResult(), p1.getSecondResult());
        List<Character> result = new ArrayList<>();
        char carry = '0';
        for (int i = pairedCharacters.size() - 1; i >= 0; i--) {
            Pair tResult = addBinary(pairedCharacters.get(i));
            if (carry == '1') {
                if (tResult.hasCarry()) result.add('1');
                else {
                    Pair cAdd = addBinary(new Pair(carry, tResult.getY()));
                    carry = cAdd.getX();
                    result.add(cAdd.getY());
                }
            } else {
                result.add(tResult.getY());
                carry = tResult.getX();
            }
        }

        Collections.reverse(result);
        StringBuilder resultBuilder = new StringBuilder();
        for (char ch : result) resultBuilder.append(ch);

        return new Result(String.valueOf(carry), resultBuilder.toString());
    }

    private String onesComplementOf(String number) {
        return number.chars()
                .map(ch -> (char) ch == '0' ? '1' : '0')
                .mapToObj(i -> (char) i + GlobalLiterals.EMPTY)
                .collect(Collectors.joining(GlobalLiterals.EMPTY));
    }

    public Data onesComplementOf() {
        return new Data(onesComplementOf(this.first), onesComplementOf(this.last));
    }

    @Override
    public String toString() {
        return "Data{" +
                "first = '" + first + '\'' +
                ", last = '" + last + '\'' +
                '}';
    }
}
