package pl.edu.agh.internetshop.strategy;
import pl.edu.agh.internetshop.MoneyTransferPaymentTransaction;
import pl.edu.agh.internetshop.Order;
import java.util.List;

public class CompositeSs implements MoneyTransferPaymentTransaction.SearchStrategy {
    private final List<MoneyTransferPaymentTransaction.SearchStrategy> filters;

    public CompositeSs(List<MoneyTransferPaymentTransaction.SearchStrategy> filters) {
        this.filters = filters;
    }

    @Override
    public boolean filter(Order order) {
        return filters.stream().allMatch(f -> f.filter(order));
    }
}