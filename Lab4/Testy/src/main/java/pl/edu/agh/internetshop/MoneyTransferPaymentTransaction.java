package pl.edu.agh.internetshop;

public interface MoneyTransferPaymentTransaction extends PaymentMethod {
    boolean validate(MoneyTransfer transfer);

    interface SearchStrategy {
        boolean filter(Order order);
    }
}
