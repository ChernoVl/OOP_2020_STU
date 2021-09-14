package sk.stuba.fei.uim.oop.shape;

import sk.stuba.fei.uim.oop.Color;

public class Circle extends Shape {

    private int radius;

    public Circle(int r, Color color) {
        super(color);
        setRadius(r);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(Integer r) {
        if (r <= 0) {
            throw new IllegalArgumentException("Invalid radius " + r);
        }
        this.radius = r;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius + "," +
                "area=" + getArea() + "," +
                "color=" + getColor() +
                '}';
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}