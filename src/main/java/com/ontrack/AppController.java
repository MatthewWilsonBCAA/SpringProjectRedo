package com.ontrack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
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

        return "index";
    }

    @RequestMapping("/new_thread")
    public String showCreateThread(Model model) {
        model.addAttribute("thread", new Thread());
        return "create_thread";
    }
    @RequestMapping(value = "/process_new_thread", method = RequestMethod.POST)
    public String processCreateThread(Thread thread, Principal user) {
        int id = Math.toIntExact(userRepo.findByEmail(user.getName()).getId());
        thread.setAuthor(id);
        //System.out.println(id + ">>>>>>>>>" + thread.getTitle());
        threadRepo.save(thread);

        return "redirect:/";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @RequestMapping("/users/profile/{id}")
    public ModelAndView showUserProfile(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("user_profile");
        User L_user = userRepo.getById((long) id);
        List<Thread> L_threads = threadRepo.findThreads(id);
        if (L_threads.size() == 0) {
            Thread zThread = new Thread();
            zThread.setTitle("NO THREADS");
            zThread.setId((long) 0);
            L_threads.add(zThread);
        }
        mav.addObject("user", L_user);
        mav.addObject("threads", L_threads);
        return mav;
    }


    @GetMapping("/threads")
    public String listThreads(Model model) {
        List<Thread> listThreads = threadRepo.findAll();
        model.addAttribute("listThreads", listThreads);
        return "threads";
    }

    @RequestMapping("/threads/{id}")
    public ModelAndView showThread(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("thread_detail");
        Thread t = threadRepo.getById((long) id);
        mav.addObject("thread", t);
        return mav;
    }

    @GetMapping("/posts")
    public String listPosts(Model model) {
        List<Post> listPosts = postRepo.findAll();
        model.addAttribute("listPosts", listPosts);
        return "posts";
    }
}