package com.ontrack.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public interface UserRepository extends JpaRepository<User, Long> {

    @Controller
    class HomeController {

        @Autowired
        private UserRepository userRepo;

        @GetMapping("")
        public String viewHomePage() {
            return "index";
        }
    }
}