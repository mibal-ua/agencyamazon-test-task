package ua.mibal.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ua.mibal.application.ReportJsonImportService;
import ua.mibal.config.properties.MongoSourceProps;

import static java.util.concurrent.TimeUnit.MINUTES;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Slf4j
@RequiredArgsConstructor
@Configuration
@EnableScheduling
@EnableConfigurationProperties({
        MongoSourceProps.class,
})
public class ReadFromJsonScheduledConfig {
    private final ReportJsonImportService reportJsonImportService;
    private final MongoSourceProps mongoSourceProps;

    @Scheduled(fixedDelay = 1, timeUnit = MINUTES)
    public void updateReportsFromJson() {
        reportJsonImportService.importFrom(mongoSourceProps.path());
        log.info("Load from " + mongoSourceProps.path());
    }
}
