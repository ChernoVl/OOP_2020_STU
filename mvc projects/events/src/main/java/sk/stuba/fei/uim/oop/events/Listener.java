package sk.stuba.fei.uim.oop.events;

//Listener - Reaguje na udalosti eventy
//Publisher - Generuje udalosti

public interface Listener<T> {

    void onEvent(T event);
}
