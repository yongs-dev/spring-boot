package com.spring.mark.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static Integer count = 0;

    static {
        users.add(new User(++count, "Ethan", LocalDate.of(1993, 4, 9)));
        users.add(new User(++count, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++count, "William", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++count);
        users.add(user);

        return user;
    }

    public void deleteById(int id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
