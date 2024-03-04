package ua.mibal.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ua.mibal.application.exception.IllegalPasswordException;
import ua.mibal.application.exception.NotAuthorizedException;
import ua.mibal.application.exception.NotFoundException;
import ua.mibal.application.exception.UsernameAlreadyExistsException;
import ua.mibal.application.model.LoginForm;
import ua.mibal.application.model.RegistrationForm;
import ua.mibal.domain.User;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@RequiredArgsConstructor
@Component
public class AuthService {
    private final UserService userService;
    private final JwtTokenService jwtTokenService;
    private final PasswordEncoder passwordEncoder;

    public String login(LoginForm loginForm) {
        try {
            return loginBy(loginForm);
        } catch (NotFoundException | IllegalPasswordException hidden) {
            // To hide from a client what is incorrect: username or password
            throw new NotAuthorizedException();
        }
    }

    public void register(RegistrationForm form) {
        validateUsernameDoesNotExist(form.username());
        userService.save(form);
    }

    private String loginBy(LoginForm form) {
        User user = userService.getOne(form.username());
        validatePasswordCorrect(form.password(), user.getPassword());
        return jwtTokenService.generateJwtToken(user);
    }

    private void validatePasswordCorrect(String guess, String original) {
        if (!passwordEncoder.matches(guess, original)) {
            throw new IllegalPasswordException();
        }
    }

    private void validateUsernameDoesNotExist(String username) {
        if (userService.isExistsByUsername(username)) {
            throw new UsernameAlreadyExistsException(username);
        }
    }
}
