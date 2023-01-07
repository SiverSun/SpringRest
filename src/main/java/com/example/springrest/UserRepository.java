package com.example.springrest;

import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static com.example.springrest.Authorities.*;

import static io.micrometer.core.instrument.Tag.of;
import static java.util.Collections.emptySet;


@Repository
public class UserRepository {

    private static final Map<String, User> USERS = new ConcurrentHashMap<>();
    private static final User ADMIN = new User("admin@gmail.com", "admin", of(READ, WRITE, DELETE));
    private static final User USER = new User("user@gmail.com", "user", of(READ, WRITE));
    private static final User GUEST = new User("guest@gmail.com", "guest", of(READ));

    static {
        create("admin", ADMIN);
        create("user", USER);
        create("guest", GUEST);
    }

    public List<User> getAll() {
        return USERS.values().stream()
                .toList();
    }

    public Set<Authorities> getAuthorities(String login, String password) {
        if (login.isEmpty() || password.isEmpty() || !USERS.containsKey(key(login))) {
            return emptySet();
        } else {
            User currentUser = USERS.get(key(login));
            if (currentUser.getPassword().equals(password)) {
                return currentUser.getAuthorities();
            } else {
                return emptySet();
            }
        }
    }

    private static void create(String key, User user) {
        USERS.put(key, user);
    }

    private static String key(String login) {
        return login.substring(0, login.indexOf("@"));
    }
}