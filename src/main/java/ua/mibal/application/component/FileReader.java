package ua.mibal.application.component;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Component
public class FileReader {

    public String read(String path) {
        try {
            return read0(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String read0(String path) throws IOException {
        Resource resource = new ClassPathResource(path);
        File file = resource.getFile();
        return Files.lines(file.toPath())
                .collect(Collectors.joining());
    }
}
