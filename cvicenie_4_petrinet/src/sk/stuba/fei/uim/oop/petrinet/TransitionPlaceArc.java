package sk.stuba.fei.uim.oop.petrinet;

public class TransitionPlaceArc extends Arc<Transition, Place> {

    public TransitionPlaceArc(Transition source, Place destination, int multiplicity) throws IllegalArgumentException {
        super(source, destination, multiplicity);
    }

    public TransitionPlaceArc(Transition source, Place destination) {
        super(source, destination);
    }

    public void produce() {
        getDestination().increaseMarking(getMultiplicity());
    }

    @Override
    public Place getPlace() {
        return getDestination();
    }

    @Override
    public Transition getTransition() {
        return getSource();
    }
}