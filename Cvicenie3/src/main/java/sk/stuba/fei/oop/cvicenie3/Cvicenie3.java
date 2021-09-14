package sk.stuba.fei.oop.cvicenie3;

public class Cvicenie3 {

    public static void main(String[] args) {
        Square square = new Square(56);
        System.out.println("square.getArea() = " + square.getArea());
        System.out.println("square.color = " + square.color);

        Circle circle = new Circle(45, Color.RED);

        Shape[] tvary = {square, new Circle(15), circle, new Square(47)};
        for (Shape tvar : tvary) {
            System.out.println("tvar <"+tvar.getClass().getSimpleName()+"> = " + tvar.getArea());
        }

    }
}
