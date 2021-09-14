package sk.stuba.fei.uim.oop.demo.service;

import sk.stuba.fei.uim.oop.demo.web.event.UserInputEvent;

public class ConsoleUserInputService implements IUserInputService {

    @Override
    public void onEvent(UserInputEvent event) {
        System.out.println("Input by user: " + event.getSource().toString());
    }
}
