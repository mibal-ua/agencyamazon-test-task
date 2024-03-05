package ua.mibal.domain;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document("reports")
public class Report {
    private ObjectId id;
    private ReportSpecification reportSpecification;
    private List<SalesAndTrafficByDate> salesAndTrafficByDate;
    private List<SalesAndTrafficByAsin> salesAndTrafficByAsin;

    public List<SalesAndTrafficByDate> getSalesAndTrafficByDates(LocalDate start, LocalDate end) {
        return salesAndTrafficByDate.stream()
                .filter(
                        item -> item.getDate().equals(start)
                                || item.getDate().equals(end)
                                || (item.getDate().isAfter(start) && item.getDate().isBefore(end))
                )
                .toList();
    }

    public List<SalesAndTrafficByAsin> getSalesAndTrafficByAsins(List<String> asins) {
        return salesAndTrafficByAsin.stream()
                .filter(item -> asins.contains(item.getParentAsin()))
                .toList();
    }
}
