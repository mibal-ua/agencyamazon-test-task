package ua.mibal.application.port;

import ua.mibal.domain.Report;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public interface ReportRepository {

    Report getReport();

    void setReport(Report report);
}
