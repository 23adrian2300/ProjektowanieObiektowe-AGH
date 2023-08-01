package pl.edu.agh.internetshop.strategy;

import pl.edu.agh.internetshop.MoneyTransferPaymentTransaction;
import pl.edu.agh.internetshop.Order;

public class BuyersSs implements MoneyTransferPaymentTransaction.SearchStrategy {
    private final String buyersSurname;

    public BuyersSs(String buyersSurname) {
        this.buyersSurname = buyersSurname;
    }

    @Override
    public boolean filter(Order order) {
        if (order.getOrdersBuyer() != null) {
            return order.getOrdersBuyer().equals(this.buyersSurname);
        }
        return false;
    }
}