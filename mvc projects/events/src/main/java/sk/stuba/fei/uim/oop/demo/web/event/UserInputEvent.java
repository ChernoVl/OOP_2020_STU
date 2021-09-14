package sk.stuba.fei.uim.oop.demo.web.event;

import sk.stuba.fei.uim.oop.demo.domain.User;
import sk.stuba.fei.uim.oop.events.Event;

public class UserInputEvent extends Event<User> {

    public UserInputEvent(User source) {
        super(source);
    }
}
