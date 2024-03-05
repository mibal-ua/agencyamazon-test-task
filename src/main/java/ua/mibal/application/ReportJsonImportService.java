package ua.mibal.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mibal.application.component.FileReader;
import ua.mibal.application.component.MongoReportConverter;
import ua.mibal.application.port.ReportRepository;
import ua.mibal.domain.Report;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@RequiredArgsConstructor
@Service
public class ReportJsonImportService {
    private final ReportRepository reportRepository;
    private final MongoReportConverter mongoReportConverter;
    private final FileReader fileReader;

    public void importFrom(String path) {
        String content = fileReader.read(path);
        Report report = mongoReportConverter.convert(content);
        reportRepository.setReport(report);
    }
}
