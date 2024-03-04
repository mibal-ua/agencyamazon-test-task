package ua.mibal.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import ua.mibal.application.ImportJsonService;
import ua.mibal.config.properties.MongoSourceProps;

import static java.util.concurrent.TimeUnit.MINUTES;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@RequiredArgsConstructor
@Configuration
@EnableConfigurationProperties({
        MongoSourceProps.class,
})
public class ReadFromJsonScheduledConfig {
    private final ImportJsonService importJsonService;
    private final MongoSourceProps mongoSourceProps;

    @Scheduled(fixedDelay = 1, timeUnit = MINUTES)
    public void updateReportsFromJson() {
        importJsonService.importFrom(mongoSourceProps.path());
    }
}
