package sk.stuba.fei.uim.oop.spring.mvcdelete;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@SpringBootApplication
public class MvcDeleteApplication implements CommandLineRunner {

    public static final String[] itemNames = {"Alpha", "Bravo", "Charlie", "Delta"};
    private final Map<Long, Item> items = new HashMap<>();

    @Override
    public void run(String... args) throws Exception {
        for (long i = 0; i < itemNames.length; i++) {
            items.put(i, new Item(i, itemNames[(int) i]));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(MvcDeleteApplication.class, args);
        log.info("Open in browser: http://localhost:8081");
    }

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("items", items.values());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteById(@PathVariable Long id) {
        items.remove(id);
        return "redirect:/";
    }
}
