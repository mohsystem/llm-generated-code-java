package codestral.task38;

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