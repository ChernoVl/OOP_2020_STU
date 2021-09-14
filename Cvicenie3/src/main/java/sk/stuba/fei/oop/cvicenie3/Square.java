package sk.stuba.fei.oop.cvicenie3;

public class Square extends Shape{

    private int a;

    public Square(int a) {
        super();
        this.a = a;
    }

    public int getA() {
        return a;
    }

    @Override
    public double getArea() {
        return this.a * this.a;
    }

    @Override
    public double getCircuit() {
        return 4 * this.a;
    }
}
