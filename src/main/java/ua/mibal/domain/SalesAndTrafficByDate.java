package ua.mibal.domain;

import lombok.Data;

import java.util.Date;

@Data
public class SalesAndTrafficByDate {
    private Date date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;
}
