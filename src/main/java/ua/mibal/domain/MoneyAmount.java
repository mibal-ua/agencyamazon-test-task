package ua.mibal.domain;

import lombok.Data;

@Data
public class MoneyAmount {
    private double amount;
    private String currencyCode;
}
