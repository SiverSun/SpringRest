package com.example.springrest;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class UserRepository {

    List<User> userRepository;

    public UserRepository() {
        userRepository = Arrays.asList(new User("Olga", "1199"),
                new User("Oleg", "54678"),
                new User("Nikolay", "266567754"));
    }

    public List<Authorities> getUserAuthorities(String login, String password) {

        for (User user : userRepository) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return Arrays.asList(Authorities.values());
            }
        }
        return new ArrayList<>();
    }
}