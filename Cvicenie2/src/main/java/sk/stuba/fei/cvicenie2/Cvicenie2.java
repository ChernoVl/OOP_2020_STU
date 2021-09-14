package sk.stuba.fei.cvicenie2;

public class Cvicenie2 {

    public static void main(String[] args) {

        Circle circle1 = new Circle(15, Color.BLUE);

        System.out.println("circle1.color = " + circle1.getColor());
        circle1.setColor(Color.RED);
        System.out.println("circle1.color = " + circle1.getColor());

        System.out.println("Color: " + circle1.getColor().getHexCode());

        System.out.println("circle1 = " + circle1.equals(circle1));

        Circle circle2 = new Circle(15);

        System.out.println("Rovnaju sa? " + circle1.equals(circle2));



    }

}
