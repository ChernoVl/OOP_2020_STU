package sk.stuba.fei.uim.oop.demo.web;

import lombok.Data;
import sk.stuba.fei.uim.oop.demo.domain.User;
import sk.stuba.fei.uim.oop.demo.web.event.UserInputEvent;
import sk.stuba.fei.uim.oop.events.Listener;
import sk.stuba.fei.uim.oop.events.Publisher;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserInterface implements Publisher<UserInputEvent> {

    private Set<Listener<UserInputEvent>> listeners;

    public UserInterface() {
        this.listeners = new HashSet<Listener<UserInputEvent>>();
    }

    public void userInput(User user) {
        UserInputEvent event = new UserInputEvent(user);
        for (Listener<UserInputEvent> listener : listeners) {
            listener.onEvent(event);
        }
    }

    @Override
    public void addListener(Listener<UserInputEvent> listener) {
        listeners.add(listener);
    }
}
