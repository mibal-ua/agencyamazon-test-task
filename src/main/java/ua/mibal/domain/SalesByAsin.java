package ua.mibal.domain;

import lombok.Data;

@Data
public class SalesByAsin {
    private int unitsOrdered;
    private int unitsOrderedB2B;
    private MoneyAmount orderedProductSales;
    private MoneyAmount orderedProductSalesB2B;
    private int totalOrderItems;
    private int totalOrderItemsB2B;
}
