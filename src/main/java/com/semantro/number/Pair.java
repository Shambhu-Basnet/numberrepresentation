package com.semantro.number;

public class Pair {

    public Character x;
    public Character y;

    public Pair(Character x, Character y) {
        this.x = x;
        this.y = y;
    }

    public Character getX() {
        return x;
    }

    public void setX(Character x) {
        this.x = x;
    }

    public Character getY() {
        return y;
    }

    public void setY(Character y) {
        this.y = y;
    }

    public boolean hasCarry(){
        return this.x != '0';
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
