package ua.mibal.application.model;

import jakarta.validation.constraints.NotNull;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public record LoginForm(
        @NotNull String login,
        @NotNull String password
) {
}
