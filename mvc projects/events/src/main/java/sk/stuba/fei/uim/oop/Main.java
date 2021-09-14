package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.demo.domain.User;
import sk.stuba.fei.uim.oop.demo.service.ConsoleUserInputService;
import sk.stuba.fei.uim.oop.demo.service.IUserInputService;
import sk.stuba.fei.uim.oop.demo.service.LoggerUserInputService;
import sk.stuba.fei.uim.oop.demo.web.UserInterface;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Main {

    public static final User[] users = {
            new User("Adam", "Krt", "kupimjalovicu@azet.sk"),
            new User("Adam", "Trnka", "predamjalovice@yahoo.com"),
            new User("Eva", "Krtova", "hladasamanzel@zoznam.sk"),
            new User("Eva", "Trnkova", "stopalkoholizmu@centrum.sk")
    };

    public static void main(String[] args) throws InterruptedException {
        IUserInputService service = new LoggerUserInputService();
        IUserInputService consoleService = new ConsoleUserInputService();
        UserInterface userInterface = new UserInterface();

        userInterface.addListener(service);
        userInterface.addListener(consoleService);

        Random random = new Random();

        while (true) {
            int index = Math.abs(random.nextInt()) % users.length;
            userInterface.userInput(users[index]);
            sleep(4000); // static import (https://docs.oracle.com/javase/7/docs/technotes/guides/language/static-import.html)
        }
    }
}
