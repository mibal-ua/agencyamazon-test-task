package ua.mibal.adapter.out.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.mibal.application.port.UserRepository;
import ua.mibal.domain.User;

import java.util.Optional;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public interface MongoUserRepository extends MongoRepository<User, Long>, UserRepository {

    @Override
    Optional<User> findByUsername(String username);
}
