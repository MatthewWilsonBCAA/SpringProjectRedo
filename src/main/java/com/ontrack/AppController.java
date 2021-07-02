package com.ontrack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ThreadRepository threadRepo;

    @Autowired
    private PostRepository postRepo;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "register_success";
    }
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/users/profile/{id}")
    public String showUserProfile(@PathVariable(name = "id") int id, Model model) {
        User L_user = userRepo.getById((long) id);
        model.addAttribute("L_user", L_user);
        return "user_profile";
    }


    @GetMapping("/threads")
    public String listThreads(Model model) {
        List<Thread> listThreads = threadRepo.findAll();
        model.addAttribute("listThreads", listThreads);
        return "threads";
    }

    @GetMapping("/posts")
    public String listPosts(Model model) {
        List<Post> listPosts = postRepo.findAll();
        model.addAttribute("listPosts", listPosts);
        return "posts";
    }
}