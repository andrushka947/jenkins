package pkg.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pkg.domain.User;

@Service
public class UserRepository {

    private static List<User> storage;

    public UserRepository() {
        storage = new ArrayList<User>();

        storage.add(new User("Andrey", 1));
        storage.add(new User("Zinur", 2));
        storage.add(new User("Misha", 3));

    }

    public User findUserById(Integer id) {
        return storage.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    public User findUserByName(String name) {
        return storage.stream().filter(u -> name.equals(u.getName())).findFirst().orElse(null);
    }

}

