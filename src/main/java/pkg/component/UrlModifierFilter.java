package pkg.component;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import pkg.domain.User;
import pkg.repository.UserRepository;

//@Component
public class UrlModifierFilter extends OncePerRequestFilter {

    private final UserRepository userRepository;

    @Autowired
    public UrlModifierFilter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        Integer userId = getUserId(request);
        System.out.println(userId);

        if (Objects.nonNull(userId)) {
            request.getRequestDispatcher("/rewrite/users/" + userId).forward(request, response);
        }
    }

    private Integer getUserId(HttpServletRequest request) {
        String URI = request.getRequestURI();
        int lastPathPartIndex = URI.lastIndexOf('/');
        String userName = URI.substring(lastPathPartIndex + 1, URI.length());

        User user = userRepository.findUserByName(userName);

        return user.getId();
    }

}
