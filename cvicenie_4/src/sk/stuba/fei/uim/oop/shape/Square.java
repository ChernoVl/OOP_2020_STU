package sk.stuba.fei.uim.oop.shape;

import sk.stuba.fei.uim.oop.Color;

import java.util.Objects;

public class Square extends Shape {

    private int side;

    public Square(int side, Color color) {
        super(color);
        setSide(side);
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return 4 * side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Invalid side " + side);
        }
        this.side = side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", color=" + getColor() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Square square = (Square) o;
        return side == square.side;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}
