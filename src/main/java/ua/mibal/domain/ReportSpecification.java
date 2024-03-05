package ua.mibal.domain;

import lombok.Data;

import java.util.List;

@Data
public class ReportSpecification {
    private String reportType;
    private ReportOptions reportOptions;
    private String dataStartTime;
    private String dataEndTime;
    private List<String> marketplaceIds;

    @Data
    private static class ReportOptions {
        private String dateGranularity;
        private String asinGranularity;
    }
}
