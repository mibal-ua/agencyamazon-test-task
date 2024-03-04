package ua.mibal.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import ua.mibal.application.component.JwtTokenBuilder;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@RequiredArgsConstructor
@Service
public class JwtTokenService {
    private final JwtEncoder encoder;
    private final JwtTokenBuilder tokenBuilder;

    public String generateJwtToken(UserDetails userDetails) {
        JwtClaimsSet jwtClaims = tokenBuilder.buildBy(userDetails);
        Jwt jwt = encoder.encode(JwtEncoderParameters.from(jwtClaims));
        return jwt.getTokenValue();
    }
}
