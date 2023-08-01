package pl.edu.agh.internetshop.strategy;

import pl.edu.agh.internetshop.MoneyTransferPaymentTransaction;
import pl.edu.agh.internetshop.Order;

import java.math.BigDecimal;

public class TotalPriceSs implements MoneyTransferPaymentTransaction.SearchStrategy {
    BigDecimal price;

    public TotalPriceSs(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean filter(Order order) {
        return order.getPriceWithTaxes().compareTo(this.price) == 0;
    }
}