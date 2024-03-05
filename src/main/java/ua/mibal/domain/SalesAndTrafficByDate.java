package ua.mibal.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SalesAndTrafficByDate {
    private String date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;

    public LocalDate getDate() {
        return LocalDate.parse(date);
    }
}
