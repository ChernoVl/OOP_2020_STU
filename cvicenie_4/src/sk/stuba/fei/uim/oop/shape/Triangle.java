package sk.stuba.fei.uim.oop.shape;

import sk.stuba.fei.uim.oop.Color;

public class Triangle extends Shape {

    private int a, b, c;

    public Triangle(int a, int b, int c, Color color) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
    }


    @Override
    public String toString() {
        return "Triangle{" +
                "color=" + getColor() +
                '}';
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}
