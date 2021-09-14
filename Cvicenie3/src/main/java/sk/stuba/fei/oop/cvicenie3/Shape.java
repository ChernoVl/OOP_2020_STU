package sk.stuba.fei.oop.cvicenie3;

public abstract class Shape {

    protected Color color;

    public Shape() {
        this.color = Color.BLACK;
    }

    public abstract double getArea();

    public abstract double getCircuit();

    public Color getColor() {
        return color;
    }
}
