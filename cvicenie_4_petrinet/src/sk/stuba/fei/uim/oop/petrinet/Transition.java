package sk.stuba.fei.uim.oop.petrinet;

import java.util.HashSet;
import java.util.Set;

public class Transition extends Vertex {

    private Set<PlaceTransitionArc> inputArcs = new HashSet<>();
    private Set<TransitionPlaceArc> outputArcs = new HashSet<>();

    public Transition(long id, String title) {
        super(id, title);
    }

    public boolean isFireable() {
        for (PlaceTransitionArc inputArc : inputArcs) {
            if (!inputArc.isSatisfied()) {
                return false;
            }
        }
        return true;
    }

    public void fire() {
        if (!isFireable())
            throw new IllegalStateException("Transition " + getTitle() + " is not fireable.");

        for (PlaceTransitionArc inputArc : inputArcs) {
            inputArc.consume();
        }

        for (TransitionPlaceArc outputArc : outputArcs) {
            outputArc.produce();
        }
    }

    public void addInputArc(PlaceTransitionArc arc) throws IllegalArgumentException {
        addArc(arc, inputArcs);
    }

    public void addOutputArc(TransitionPlaceArc arc) throws IllegalArgumentException {
        addArc(arc, outputArcs);
    }

    private <T extends Arc> void addArc(T arc, Set<T> arcs) {
    }

    @Override
    public String toString() {
        return "Transition(" + getId() + ")";
    }
}