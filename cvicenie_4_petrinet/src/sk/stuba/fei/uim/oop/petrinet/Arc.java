package sk.stuba.fei.uim.oop.petrinet;

public abstract class Arc<S extends Vertex, D extends Vertex> {

    private S source;
    private D destination;
    private int multiplicity = 1;

    public Arc(S source, D destination, int multiplicity) throws IllegalArgumentException {
        this(source, destination);
        setMultiplicity(multiplicity);
    }

    public Arc(S source, D destination) {
        if (source == null || destination == null)
            throw new IllegalArgumentException("Can not create arc from/to null vertex");
        this.source = source;
        this.destination = destination;
    }

    public int getMultiplicity() {
        return multiplicity;
    }

    public void setMultiplicity(int multiplicity) throws IllegalArgumentException {
        if (multiplicity < 1)
            throw new IllegalArgumentException("Multiplicity can not be less than 1.");

        this.multiplicity = multiplicity;
    }

    public S getSource() {
        return source;
    }

    public D getDestination() {
        return destination;
    }

    public abstract Place getPlace();

    public abstract Transition getTransition();
}