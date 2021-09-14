package sk.stuba.fei.uim.oop.petrinet;

public class PlaceTransitionArc extends Arc<Place, Transition> {

    public PlaceTransitionArc(Place source, Transition destination, int multiplicity) throws IllegalArgumentException {
        super(source, destination, multiplicity);
    }

    public PlaceTransitionArc(Place source, Transition destination) {
        super(source, destination);
    }

    public boolean isSatisfied() {
        return getPlace().getMarking() >= getMultiplicity();
    }

    public void consume() {
        getPlace().decreaseMarking(getMultiplicity());
    }

    @Override
    public Place getPlace() {
        return getSource();
    }

    @Override
    public Transition getTransition() {
        return getDestination();
    }
}