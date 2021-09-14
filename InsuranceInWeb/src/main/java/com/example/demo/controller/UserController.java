package com.example.demo.controller;

import com.example.demo.domain.Address;
import com.example.demo.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
//@RequestMapping("/user")
public class UserController implements CommandLineRunner {
    private static Address address = new Address("08500", null, "Stare Grunty", "12/a");

    public static final User[] items = {
            new User("Vlad", "Chernov", "098/32", "test@mail.com", address, null),
            new User("Peter2", "sPete2r", "098/332", "test2@mail.com", address, null)};

    private final Map<Long,User> users = new HashMap<>();

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < items.length; i++) {
            users.put(items[i].getId(), items[i]);
            //users.add(items[i]);
        }
    }

    @GetMapping("/user/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping("/user/add")
    public String addSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        System.out.println("Post" + user);
        return "user/add";
    }

    @GetMapping("/user/viewall")
    public String findAll(Model model) {
        model.addAttribute("users", users);
        return "/user/viewall";
    }

    @PostMapping("/user/viewall")
    public  String find(){
        return "/user/viewall";
    }

    @GetMapping("/user/viewdetails/{id}")
    public String ViewDetailsById(@PathVariable Long id, Model model) {
        User user = users.get(id);
        model.addAttribute("user", user);
        return "/user/viewdetails";
    }

    @GetMapping("user/changeuser/{id}")
    public String ChangeById(@PathVariable Long id) {
        users.remove(id);
        return "user/changeuser";
    }

    @PostMapping("/user/changeuser/")
    public String ChangeByIdPost(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        return "user/changeuser";
    }

}
