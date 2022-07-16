package com.semantro.number;

import java.util.ArrayList;
import java.util.List;

public class SemantroNumber {
    Data data;
    Type type;

    public SemantroNumber(Data data, Type type) {
        this.data = data;
        this.type = type;
    }

    public Data getData() {
        return data;
    }

    public Type getType() {
        return type;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isBinary() {
        return type == Type.BINARY;
    }

    public boolean isDecimal() {
        return type == Type.DECIMAL;
    }

    public SemantroNumber add(SemantroNumber other) {
        if (this.isBinary() && other.isBinary()) {
            Data result = this.data.add(other.data);
            return new SemantroNumber(result, Type.BINARY);
        } else if (this.isBinary() && other.isDecimal()) {
            Data result = this.data.add(other.data.getBinary());
            return new SemantroNumber(result, Type.BINARY);
        } else if (this.isDecimal() && other.isDecimal()) {
            Data result = this.data.getBinary().add(other.data.getBinary());
            return new SemantroNumber(result, Type.BINARY);
        } else {
            Data result = this.data.getBinary().add(other.data);
            return new SemantroNumber(result, Type.BINARY);
        }
    }

    /**
     * Perform Subtraction with other number.
     *
     * @param other
     * @return semantroNumber
     */

    public SemantroNumber subtract(SemantroNumber other) {
        List<String> last = new ArrayList<>();

        if (this.data.getLast().equals(GlobalLiterals.EMPTY)) {
            for (int i = 0; i < other.data.getLast().length(); i++) {
                last.add("0");
            }
//            String paddedString = String.join("", last);
            this.data.setLast(String.join(GlobalLiterals.EMPTY, last));
        } else if (other.data.getLast().equals(GlobalLiterals.EMPTY)) {
            for (int i = 0; i < this.data.getLast().length(); i++) {
                last.add("0");
            }
//            String paddedString = String.join("", last);
            other.data.setLast(String.join("", last));
        } else if (other.data.getLast().length() < this.data.getLast().length()) {
            last.add(other.data.getLast());
            int difference = this.data.getLast().length() - other.data.getLast().length();
            for (int i = 0; i < difference; i++) {
                last.add("0");
            }
            other.data.setLast(String.join("", last));
        }


        if (StringUtils.isGreaterThan(this.data.getFirst(), other.data.getFirst())) {
            Data onesComplement = this.data.onesComplementOf();
            SemantroNumber intermediate = new SemantroNumber(onesComplement, Type.BINARY).add(other);
            return new SemantroNumber(intermediate.data.onesComplementOf(), Type.BINARY);
        } else {
            Data onesComplement = other.data.onesComplementOf();
            SemantroNumber intermediate = new SemantroNumber(onesComplement, Type.BINARY).add(this);
            return new SemantroNumber(intermediate.data.onesComplementOf(), Type.BINARY);
        }
    }

    /**
     * Perform multiplication with other number.
     *
     * @return semantroNumber
     */
    public SemantroNumber multiply(SemantroNumber other) {
        if (this.isEmpty() || this.isZero()) {
            return this;
        } else if (other.isEmpty() || other.isZero()) {
            return other;
        } else {
            int s1 = Integer.parseInt(Binary.of(other.getData().getFirst()).toIntOfFirst());
            double s2 = Binary.of(other.getData().getLast()).toIntOfLast();

            RationalNumber r1 = new RationalNumber().toFraction(s1 + s2);
            int guard = r1.numerator;
            SemantroNumber temporaryResult = this;

            for (int index = 1; index <= guard - 1; index++) temporaryResult = temporaryResult.add(this);

            SemantroNumber divisor = new SemantroNumber(new Data((String.valueOf(Decimal.of(String.valueOf((r1.denominator))).toBinaryOfFirst())), ""), Type.BINARY);
            int count = 0;
            long temp = Long.parseLong(temporaryResult.getData().getFirst());

            while (true) {
                if (temp > Long.parseLong(divisor.getData().getFirst())) {
                    temporaryResult = temporaryResult.subtract(divisor);
                    count = count + 1;
                    temp = Long.parseLong(temporaryResult.getData().getFirst());
                } else if (temp == Long.parseLong(divisor.getData().getFirst())) {
                    SemantroNumber result1 = temporaryResult;
                    temporaryResult = new SemantroNumber(new Data("0", result1.getData().getLast()), Type.BINARY);
                    count = count + 1;
                    temp = Long.parseLong(result1.getData().getFirst());
                    break;
                } else {
                    break;
                }
            }

            int first = Integer.parseInt(Binary.of(temporaryResult.getData().getFirst()).toIntOfFirst());
            double second = Binary.of(temporaryResult.getData().getLast()).toIntOfLast();

            String splittedString = StringUtils.stringSplit(String.valueOf((first + second) / r1.denominator));

            return new SemantroNumber(new Data(Decimal.of(String.valueOf(count)).toBinaryOfFirst(), Decimal.of(splittedString).toBinaryOfLast()), Type.BINARY);
        }
    }

    /**
     * Perform Division with other number.
     *
     * @return semantroNumber
     */

    public SemantroNumber divide(SemantroNumber other) {
        if (this.isEmpty() || this.isZero()) {
            return new SemantroNumber(new Data("0", "0"), Type.BINARY);
        } else if (other.isEmpty() || other.isZero()) {
            return new SemantroNumber(new Data("Infinity", "Infinity"), Type.BINARY);
        } else {
            int s1 = Integer.parseInt(Binary.of(other.getData().getFirst()).toIntOfFirst());
            double s2 = Binary.of(other.getData().getLast()).toIntOfLast();

            RationalNumber r1 = new RationalNumber().toFraction(s1 + s2);

            int guard = r1.denominator;

            SemantroNumber temporaryResult = this;

            for (int index = 0; index < guard - 1; index++) {
                temporaryResult = temporaryResult.add(this);
            }

            SemantroNumber divisor = new SemantroNumber(new Data((String.valueOf(Decimal.of(String.valueOf((r1.numerator))).toBinaryOfFirst())), ""), Type.BINARY);

            int count = 0;
            int temp = Integer.parseInt(temporaryResult.getData().getFirst());

            while (true) {
                if (temp > Integer.parseInt(divisor.getData().getFirst())) {
                    temporaryResult = temporaryResult.subtract(divisor);
                    count = count + 1;
                    temp = Integer.parseInt(temporaryResult.getData().getFirst());
                } else if (temp == Integer.parseInt(divisor.getData().getFirst())) {
                    SemantroNumber result1 = temporaryResult;
                    temporaryResult = new SemantroNumber(new Data("0", result1.getData().getLast()), Type.BINARY);
                    count = count + 1;
                    temp = Integer.parseInt(result1.getData().getFirst());
                    break;
                } else {
                    break;
                }
            }

            int first = Integer.parseInt(Binary.of(temporaryResult.getData().getFirst()).toIntOfFirst());
            double second = Binary.of(temporaryResult.getData().getLast()).toIntOfLast();

            String splittedString = StringUtils.stringSplit(String.valueOf((first + second) / r1.numerator));

            return new SemantroNumber(new Data(Decimal.of(String.valueOf(count)).toBinaryOfFirst(), Decimal.of(splittedString).toBinaryOfLast()), Type.BINARY);
        }
    }

    private boolean isEmpty() {
        return data.isEmpty();
    }

    private boolean isZero() {
        return data.isZero();
    }


    @Override
    public String toString() {
        return "SemantroNumber{" +
                "data=" + data +
                ", type=" + type +
                '}';
    }
}
