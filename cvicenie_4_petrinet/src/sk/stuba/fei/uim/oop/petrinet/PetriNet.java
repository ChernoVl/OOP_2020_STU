package sk.stuba.fei.uim.oop.petrinet;

import java.util.*;

public class PetriNet {

    private Map<Long, Place> places = new HashMap<>();
    private Map<Long, Transition> transitions = new HashMap<>();
    private Set<Arc> arcs = new HashSet<>();

    public void fireTransition(long transitionId) {
        Transition transition = transitions.get(transitionId);
        if (transition == null) {
            throw new IllegalArgumentException("Transition "+transitionId +" does not exists");
        }
        transition.fire();
    }

    public void addPlace(Place place) {
        places.put(place.getId(), place);
    }

    public void addTransition(Transition transition) {
        transitions.put(transition.getId(), transition);
    }

    public void addPTArc(Place p, Transition t) {
        addPTArc(p, t, 1);
    }

    private void addPTArc(Place p, Transition t, int multiplicity) {
        if (t == null || p == null) {
            throw new IllegalArgumentException("Can not create arc from " + p + " to " + t);
        }
        PlaceTransitionArc arc = new PlaceTransitionArc(p, t, multiplicity);
        t.addInputArc(arc);
        arcs.add(arc);
    }

    public void addTPArc(Transition t, Place p) {
        addTPArc(t, p, 1);
    }

    private void addTPArc(Transition t, Place p, int multiplicity) {
        if (t == null || p == null) {
            throw new IllegalArgumentException("Can not create arc from " + t + " to " + p);
        }
        TransitionPlaceArc arc = new TransitionPlaceArc(t, p);
        t.addOutputArc(arc);
        arcs.add(arc);
    }

    public void addArc(long sourceId, long destinationId, int multiplicity) {
        if (places.containsKey(sourceId)) {
            addPTArc(places.get(sourceId), transitions.get(destinationId), multiplicity);
        } else {
            addTPArc(transitions.get(sourceId), places.get(destinationId), multiplicity);
        }
    }

    public List<Place> getPlaces() {
        return new LinkedList<>(places.values());
    }

    public List<Transition> getTransitions() {
        return new LinkedList<>(transitions.values());
    }

    public Set<Arc> getArcs() {
        return arcs;
    }
}