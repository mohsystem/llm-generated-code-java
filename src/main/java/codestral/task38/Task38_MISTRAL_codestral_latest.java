package codestral.task38;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Java code using Spring Boot framework
// Controller
@Controller
public class Task38_MISTRAL_codestral_latest {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/submit")
    public String submit(@RequestParam("user_input") String userInput, Model model) {
        model.addAttribute("user_input", userInput);
        return "result";
    }
}