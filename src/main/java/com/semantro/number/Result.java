package com.semantro.number;

public class Result {

    String carry;
    String value;

    public String getCarry() {
        return carry;
    }

    public void setCarry(String carry) {
        this.carry = carry;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Result(String carry, String value) {
        this.carry = carry;
        this.value = value;
    }

    public boolean hasCarry(){
        return !this.carry.isEmpty();
    }

    @Override
    public String toString() {
        return "Result{" +
                "carry='" + carry + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
