package sk.stuba.fei.uim.oop.events;

//Listener - Reaguje na udalosti eventy
//Publisher - Generuje udalosti

public interface Publisher<T> {
    void addListener(Listener<T> listener);
}