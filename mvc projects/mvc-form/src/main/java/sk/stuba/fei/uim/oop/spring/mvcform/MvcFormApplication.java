package sk.stuba.fei.uim.oop.spring.mvcform;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@SpringBootApplication
public class MvcFormApplication {

    private Item item = new Item(true, LocalDate.now(), LocalDateTime.now(), 5, "Hello!");
    private List<Item> items = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(MvcFormApplication.class, args);
        log.info("Open in browser: http://localhost:8081");
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("item", item);
        //model.addAttribute("item", new Item()); // створиться новий порожній Item
        return "index"; //і вкладеться в -> index і той індекс зобразиться на стронці
    }

    @PostMapping("/")
    public String submit(@ModelAttribute Item item, Model model) {
        items.add(item);
        model.addAttribute("item", item);
        return "submitted";
    }
}