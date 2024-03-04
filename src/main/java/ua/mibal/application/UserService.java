package ua.mibal.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ua.mibal.application.exception.NotFoundException;
import ua.mibal.application.mapper.UserMapper;
import ua.mibal.application.model.RegistrationForm;
import ua.mibal.application.port.UserRepository;
import ua.mibal.domain.User;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@RequiredArgsConstructor
@Component
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public void save(RegistrationForm form) {
        String encodedPassword = passwordEncoder.encode(form.password());
        User user = userMapper.assemble(form, encodedPassword);
        userRepository.save(user);
    }

    public boolean isExistsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public User getOne(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(NotFoundException::new);
    }
}
