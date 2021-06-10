package com.ontrack.users;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class UserService {
    public List<User> getUsers() {
        User me = new User(1L, "MATT", "thematbat@gmail.com", LocalDate.of(2021, Month.JUNE, 10));
        return List.of(me);
    }
}
