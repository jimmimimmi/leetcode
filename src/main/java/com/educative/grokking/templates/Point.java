package com.educative.grokking.templates;

public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance() {
        return Math.sqrt(x * x + y * y);
    }
}