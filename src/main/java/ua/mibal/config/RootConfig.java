package ua.mibal.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ua.mibal.config.properties.JwtTokenProps;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Configuration
@EnableConfigurationProperties({
        JwtTokenProps.class,
})
public class RootConfig {
}
