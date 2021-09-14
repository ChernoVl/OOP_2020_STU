package sk.stuba.fei.uim.oop.petrinet;

public class Place extends Vertex {

    private int marking = 0;

    public Place(long id, String title, int marking) throws IllegalArgumentException {
        this(id, title);
        setMarking(marking);
    }

    public Place(long id, String title) {
        super(id, title);
    }

    public int getMarking() {
        return marking;
    }

    public void setMarking(int marking) throws IllegalArgumentException {
        if (marking < 0)
            throw new IllegalArgumentException("Marking can not be negative number.");
        this.marking = marking;
    }

    public void increaseMarking(int value) throws IllegalArgumentException {
        setMarking(marking + value);
    }

    public void decreaseMarking(int value) throws IllegalArgumentException {
        setMarking(marking - value);
    }

    @Override
    public String toString() {
        return "Place(" + getId() + ")";
    }
}