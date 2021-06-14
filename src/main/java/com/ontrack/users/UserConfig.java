package com.ontrack.users;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner (UserRepository repository) {
        return args -> {
            new User(1L,
                    "MATT",
                    "thematbat@gmail.com",
                    LocalDate.of(2021, Month.JUNE, 10)
            );
        };
    }
}
