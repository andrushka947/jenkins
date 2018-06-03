package pkg.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pkg.domain.User;
import pkg.repository.UserRepository;

@RestController()
@RequestMapping("/rewrite")
public class RewriteController {

    private final UserRepository userRepository;

    @Autowired
    public RewriteController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable("userId") Integer userId, HttpServletResponse resp) {
        User user = userRepository.findUserById(userId);
        if (Objects.nonNull(user)) {
            resp.setHeader("Location", "/rewrite/users/" + user.getName());
            return user;
        }

        return new User("User with such id was not found", userId);
    }

}


