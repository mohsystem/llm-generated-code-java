package codestral.task49;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Java
@RestController
@RequestMapping("/api")
public class Task49_MISTRAL_codestral_latest {

    //invalid code
//    @Autowired
//    private UserRepository userRepository;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return user;
    }
}