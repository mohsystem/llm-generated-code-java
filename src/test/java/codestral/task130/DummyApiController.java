package codestral.task130;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyApiController {
    @GetMapping("/api")
    public String getData() {
        return "{\"message\": \"This is dummy response\"}";
    }
}
