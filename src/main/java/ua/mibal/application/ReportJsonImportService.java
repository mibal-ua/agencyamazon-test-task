package ua.mibal.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mibal.adapter.out.repository.MongoReportRepository;
import ua.mibal.application.component.FileReader;
import ua.mibal.application.component.MongoReportConverter;
import ua.mibal.domain.Report;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@RequiredArgsConstructor
@Service
public class ReportJsonImportService {
    private final MongoReportRepository reportRepository;
    private final MongoReportConverter mongoReportConverter;
    private final FileReader fileReader;

    public void importFrom(String path) {
        List<String> lines = fileReader.readLines(path);
        List<Report> reports = mongoReportConverter.convert(lines);
        reportRepository.deleteAll();
        reportRepository.saveAll(reports);
    }
}
