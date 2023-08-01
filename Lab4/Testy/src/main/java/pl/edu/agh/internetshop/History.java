package pl.edu.agh.internetshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class History {
    private final List<Order> oldOrders;

    public History(List<Order> oldOrders) {
        this.oldOrders = Objects.requireNonNull(oldOrders, "Cannot be null");
        this.oldOrders.forEach((p) -> Objects.requireNonNull(p,"Order cannot be null"));
    }

    public void addOrder(Order order){
        this.oldOrders.add(order);
    }

    public List<Order> getOldOrders() {
        return oldOrders;
    }

    public List<Order> getOrdersFiltred(MoneyTransferPaymentTransaction.SearchStrategy searchStrategy) {
        List<Order> resultList = new ArrayList<>();
        for (Order order: oldOrders) {
            if (searchStrategy.filter(order)) {
                resultList.add(order);
            }
        }
        return resultList;
    }
}