package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.strategy.BuyersSs;
import pl.edu.agh.internetshop.strategy.CompositeSs;
import pl.edu.agh.internetshop.strategy.ProductSs;
import pl.edu.agh.internetshop.strategy.TotalPriceSs;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CompositeSsTest {
    private Order getOrder() {
        Order order = mock(Order.class);
        List<Product> productList = Arrays.asList(
                new Product("Banana", BigDecimal.valueOf(43.05), BigDecimal.valueOf(0.5)),
                new Product("Orange", BigDecimal.valueOf(54.83), BigDecimal.valueOf(0.23))
        );
        given(order.getProducts()).willReturn(productList);
        given(order.getPriceWithTaxes()).willReturn(BigDecimal.valueOf(10));
        given(order.getOrdersBuyer()).willReturn("Surname");
        return order;
    }

    @Test
    public void sameAllParameters() {
        // given
        Order order = getOrder();
        MoneyTransferPaymentTransaction.SearchStrategy productNameSearchStrategy = new ProductSs("Banana");
        MoneyTransferPaymentTransaction.SearchStrategy payersSurnameSearchStrategy = new BuyersSs("Surname");
        MoneyTransferPaymentTransaction.SearchStrategy totalPriceSearchStrategy = new TotalPriceSs(BigDecimal.valueOf(10));

        // when
        CompositeSs searchStrategy = new CompositeSs(
                Arrays.asList(productNameSearchStrategy, payersSurnameSearchStrategy, totalPriceSearchStrategy));

        // then
        assertTrue(searchStrategy.filter(order));
    }

    @Test
    public void sameAllParametersNotProduct() {
        // given
        Order order = getOrder();
        MoneyTransferPaymentTransaction.SearchStrategy productNameSearchStrategy = new ProductSs("Apple");
        MoneyTransferPaymentTransaction.SearchStrategy payersSurnameSearchStrategy = new BuyersSs("Surname");
        MoneyTransferPaymentTransaction.SearchStrategy totalPriceSearchStrategy = new TotalPriceSs(BigDecimal.valueOf(10));

        // when
        CompositeSs searchStrategy = new CompositeSs(
                Arrays.asList(productNameSearchStrategy, payersSurnameSearchStrategy, totalPriceSearchStrategy));

        // then
        assertFalse(searchStrategy.filter(order));
    }

    @Test
    public void sameAllParametersNotBuyers() {
        // given
        Order order = getOrder();
        MoneyTransferPaymentTransaction.SearchStrategy productNameSearchStrategy = new ProductSs("Orange");
        MoneyTransferPaymentTransaction.SearchStrategy payersSurnameSearchStrategy = new BuyersSs("notSurname");
        MoneyTransferPaymentTransaction.SearchStrategy totalPriceSearchStrategy = new TotalPriceSs(BigDecimal.valueOf(10));

        // when
        CompositeSs searchStrategy = new CompositeSs(
                Arrays.asList(productNameSearchStrategy, payersSurnameSearchStrategy, totalPriceSearchStrategy));

        // then
        assertFalse(searchStrategy.filter(order));
    }

    @Test
    public void sameAllParametersNotTotalPrice() {
        // given
        Order order = getOrder();
        MoneyTransferPaymentTransaction.SearchStrategy productNameSearchStrategy = new ProductSs("Orange");
        MoneyTransferPaymentTransaction.SearchStrategy payersSurnameSearchStrategy = new BuyersSs("Surname");
        MoneyTransferPaymentTransaction.SearchStrategy totalPriceSearchStrategy = new TotalPriceSs(BigDecimal.valueOf(9));

        // when
        CompositeSs searchStrategy = new CompositeSs(
                Arrays.asList(productNameSearchStrategy, payersSurnameSearchStrategy, totalPriceSearchStrategy));

        // then
        assertFalse(searchStrategy.filter(order));
    }
}