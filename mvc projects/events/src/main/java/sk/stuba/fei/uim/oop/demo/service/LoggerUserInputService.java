package sk.stuba.fei.uim.oop.demo.service;

import lombok.extern.slf4j.Slf4j;
import sk.stuba.fei.uim.oop.demo.web.event.UserInputEvent;

@Slf4j
public class LoggerUserInputService implements IUserInputService {

    @Override
    public void onEvent(UserInputEvent event) {
        log.info("Input by user: " + event.getSource().toString());
    }
}
