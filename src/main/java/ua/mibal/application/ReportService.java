package ua.mibal.application;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ua.mibal.application.port.ReportRepository;
import ua.mibal.domain.Report;
import ua.mibal.domain.SalesAndTrafficByAsin;
import ua.mibal.domain.SalesAndTrafficByDate;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@RequiredArgsConstructor
@Service
public class ReportService {
    private final ReportRepository reportRepository;

    @Cacheable("ReportService.findByDate")
    public List<SalesAndTrafficByDate> findByDate(LocalDate start, LocalDate end) {
        Report report = reportRepository.getReport();
        return report.getSalesAndTrafficByDates(start, end);
    }

    @Cacheable("ReportService.findByAsins")
    public List<SalesAndTrafficByAsin> findByAsins(List<String> asins) {
        Report report = reportRepository.getReport();
        return report.getSalesAndTrafficByAsins(asins);
    }
}
