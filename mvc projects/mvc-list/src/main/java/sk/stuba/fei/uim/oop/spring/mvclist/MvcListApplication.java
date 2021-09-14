package sk.stuba.fei.uim.oop.spring.mvclist;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Slf4j
@Controller
@SpringBootApplication
public class MvcListApplication implements CommandLineRunner {

    public static final String[] itemNames = {"Alpha", "Bravo", "Charlie", "Delta"};
    private final List<Item> items = new LinkedList<>();

    public static void main(String[] args) {
        SpringApplication.run(MvcListApplication.class, args);
        log.info("Open in browser: http://localhost:8081");
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < itemNames.length; i++) {
            items.add(new Item(i,itemNames[i]));
        }
        items.add(new Item(15, "Peter Parker"));
    }

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("items", items);
        return "index";
    }

    @PostMapping("/")
    public  String find(){
        return "index";
    }

    @GetMapping("/add")
    public String addRandom(Model model) {
        Random rnd = new Random();
        items.add(new Item(rnd.nextInt(90) + 10,itemNames[rnd.nextInt(itemNames.length)]));
        model.addAttribute("items", items);
        return "index";
    }
}
