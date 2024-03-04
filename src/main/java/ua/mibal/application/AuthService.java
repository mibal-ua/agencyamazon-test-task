package ua.mibal.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.mibal.application.exception.UsernameAlreadyExistsException;
import ua.mibal.application.model.LoginForm;
import ua.mibal.application.model.RegistrationForm;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@RequiredArgsConstructor
@Component
public class AuthService {
    private final UserService userService;

    public String login(LoginForm loginForm) {
        // TODO
        return null;
    }

    public void register(RegistrationForm form) {
        validateUsernameDoesNotExist(form.username());
        userService.save(form);
    }

    private void validateUsernameDoesNotExist(String username) {
        if (userService.isExistsByUsername(username)) {
            throw new UsernameAlreadyExistsException(username);
        }
    }
}
