package ua.mibal.application.mapper;

import org.springframework.stereotype.Component;
import ua.mibal.application.model.RegistrationForm;
import ua.mibal.domain.User;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Component
public class UserMapper {

    public User assemble(RegistrationForm form, String password) {
        User user = new User();
        user.setName(form.name());
        user.setUsername(form.username());
        user.setPassword(password);
        return user;
    }
}
