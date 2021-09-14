package sk.stuba.fei.uim.oop;

import java.util.LinkedList;
import java.util.List;

public class Canvas<T extends Printable> {

    private List<T> printables;

    public Canvas() {
        printables = new LinkedList<>();
    }

    public List<T> getPrintables() {
        return printables;
    }

    public void addPrintable(T shape) {
        printables.add(shape);
    }

    public void print() {
        for (T printable : printables) {
            printable.print();
        }
    }
}
