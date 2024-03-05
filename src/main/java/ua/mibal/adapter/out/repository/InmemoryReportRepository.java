package ua.mibal.adapter.out.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ua.mibal.application.port.ReportRepository;
import ua.mibal.domain.Report;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Setter
@Getter
@Component
public class InmemoryReportRepository implements ReportRepository {
    private Report report;
}
