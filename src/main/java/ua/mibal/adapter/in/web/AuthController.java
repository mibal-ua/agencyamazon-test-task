package ua.mibal.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.mibal.adapter.in.web.mapper.TokenDtoMapper;
import ua.mibal.adapter.in.web.model.TokenDto;
import ua.mibal.application.AuthService;
import ua.mibal.application.model.LoginForm;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final TokenDtoMapper tokenDtoMapper;

    @PostMapping("/login")
    public TokenDto login(@RequestBody LoginForm loginForm) {
        String token = authService.login(loginForm);
        return tokenDtoMapper.toDto(token);
    }
}
