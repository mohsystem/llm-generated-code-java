package codestral.task49;

// Java
@RestController
@RequestMapping("/api")
public class Task49_MISTRAL_codestral_latest {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}