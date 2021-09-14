package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.shape.Circle;
import sk.stuba.fei.uim.oop.shape.Shape;
import sk.stuba.fei.uim.oop.shape.Square;
import sk.stuba.fei.uim.oop.shape.Triangle;

public class Main {

    public static void main(String[] args) {
        Canvas<Printable> canvas = new Canvas<>();

        canvas.addPrintable(new Circle(5, Color.RED));
        canvas.addPrintable(new Square(3, Color.GREEN));
        canvas.addPrintable(new Triangle(1, 2, 3, Color.BLUE));

        canvas.print();

        canvas.addPrintable(new Text("text"));

        canvas.print();
    }
}