package ua.mibal.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import ua.mibal.application.CacheService;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Slf4j
@RequiredArgsConstructor
@Configuration
public class ClearCachesScheduledConfig {
    private final CacheService cacheService;

    @Scheduled(fixedRate = 10, timeUnit = SECONDS)
    public void clearAllCaches() {
        cacheService.clearAllCaches();
        log.info("Clear caches");
    }
}
