package sk.stuba.fei.oop.cvicenie3;

import java.util.Objects;

public class Circle extends Shape{

    private int radius;

    public Circle(){
        super();
    }

    public Circle(int radius) {
        this();
        this.radius = radius;
    }

    public Circle(int radius, Color color) {
        this();
        this.radius = radius;
        this.color = color;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public double getCircuit() {
        return 2 * Math.PI * this.radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color=" + color +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, color);
    }
}
