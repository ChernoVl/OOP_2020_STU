package sk.stuba.fei.cvicenie2;

import java.util.Objects;

public class Circle {

    private int radius;
    private Color color;

    public Circle(){

    }

    public Circle(int radius) {
        this.radius = radius;
        //setRadius();// TODO
    }

    public Circle(int radius, Color color) {
       // this.radius = radius;
        this(radius);
        //this.color = color;
        setColor(color);
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public static double getCircuit(Circle circle) {
        return 2 * Math.PI * circle.radius;
    }

    public int getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if(color == null){
            throw new IllegalArgumentException();
        }
//        if(!color.matches("[0-9a-z]{6}")){
//            throw new IllegalArgumentException();
//        }
        this.color = color;
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
