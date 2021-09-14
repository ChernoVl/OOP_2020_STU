package sk.stuba.fei.uim.oop.spring.mvcvalidation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@SpringBootApplication
public class MvcValidationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcValidationApplication.class, args);
        log.info("Open in browser: http://localhost:8081");
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("item", new Item(0, ""));
        return "index";
    }

    @PostMapping
    public String submit(@ModelAttribute @Valid Item item, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        model.addAttribute("item", item);
        return "submitted";
    }
}
