package sk.stuba.fei.uim.oop.shape;

import sk.stuba.fei.uim.oop.Color;
import sk.stuba.fei.uim.oop.Printable;

public abstract class Shape extends Printable {

    private Color color;

    public Shape(Color color) {
        setColor(color);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (color == null) {
            throw new IllegalArgumentException();
        }
        this.color = color;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return color == shape.color;
    }
}
