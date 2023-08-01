package pl.edu.agh.internetshop.strategy;

import pl.edu.agh.internetshop.MoneyTransferPaymentTransaction;
import pl.edu.agh.internetshop.Order;
import pl.edu.agh.internetshop.Product;

import java.util.List;

public class ProductSs implements MoneyTransferPaymentTransaction.SearchStrategy {
    private final String name;

    public ProductSs(String name) {
        this.name = name;
    }

    @Override
    public boolean filter(Order order) {
        List<Product> products = order.getProducts();
        for (Product product: products) {
            if (product.getName().equals(this.name)) {
                return true;
            }
        }
        return false;
    }
}