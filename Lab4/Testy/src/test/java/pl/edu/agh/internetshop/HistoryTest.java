package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.strategy.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class HistoryTest {
    @Test
    void getMultipleOrdersFromOrdersHistory() {
        // given
        List<Order> orders = Arrays.asList(mock(Order.class), mock(Order.class));
        // when
        History history = new History(orders);

        // then
        assertEquals(2, history.getOldOrders().size());
        assertSame(orders.get(0), history.getOldOrders().get(0));
        assertSame(orders.get(1), history.getOldOrders().get(1));
    }

    @Test
    void getOldOrdersAddingOrders() {
        // given
        Order expectedOrder = mock(Order.class);
        // when
        History history = new History(new ArrayList<>());
        history.addOrder(expectedOrder);
        // then
        assertEquals(1, history.getOldOrders().size());
        assertSame(expectedOrder, history.getOldOrders().get(0));
    }
    @Test
    public void listOldOrdersIsNull() {
        // given
        List<Order> pastOrders = Arrays.asList(mock(Order.class), null);
        // when then
        assertThrows(NullPointerException.class, () -> new History(pastOrders));
    }

    @Test
    void getFilteredOrdersWithProductName() {
        // given
        Product product = mock(Product.class);
        Product product1 = mock(Product.class);
        Product product2 = mock(Product.class);
        Product product3 = mock(Product.class);
        given(product.getName()).willReturn("Strawberry");
        given(product1.getName()).willReturn("Lemon");
        given(product2.getName()).willReturn("Onion");
        given(product3.getName()).willReturn("Chili");
        Order order = mock(Order.class);
        Order order1 = mock(Order.class);
        Order order2 = mock(Order.class);
        given(order.getProducts()).willReturn(Arrays.asList(product, product1));
        given(order1.getProducts()).willReturn(Arrays.asList(product1, product3));
        given(order2.getProducts()).willReturn(Arrays.asList(product, product1, product2, product3));
        MoneyTransferPaymentTransaction.SearchStrategy searchStrategy = new ProductSs("Strawberry");

        // when
        History history = new History(Arrays.asList(order, order1, order2));

        // then
        assertEquals(2, history.getOrdersFiltred(searchStrategy).size());
        assertSame(order, history.getOrdersFiltred(searchStrategy).get(0));
        assertSame(order2, history.getOrdersFiltred(searchStrategy).get(1));
    }

    @Test
    void getFilteredOrdersWithBuyers() {
        // given
        Order order = mock(Order.class);
        Order order1 = mock(Order.class);
        Order order2 = mock(Order.class);
        given(order.getOrdersBuyer()).willReturn("Nowak");
        given(order1.getOrdersBuyer()).willReturn("Kowalski");
        given(order2.getOrdersBuyer()).willReturn("Nowak");
        MoneyTransferPaymentTransaction.SearchStrategy searchStrategy = new BuyersSs("Nowak");

        // when
        History history = new History(Arrays.asList(order, order1, order2));

        // then
        assertEquals(2, history.getOrdersFiltred(searchStrategy).size());
        assertSame(order, history.getOrdersFiltred(searchStrategy).get(0));
        assertSame(order2, history.getOrdersFiltred(searchStrategy).get(1));
    }

    @Test
    void getFilteredOrdersTotalPrice() {
        // given
        Order order = mock(Order.class);
        Order order1 = mock(Order.class);
        given(order.getPriceWithTaxes()).willReturn(BigDecimal.valueOf(15));
        given(order1.getPriceWithTaxes()).willReturn(BigDecimal.valueOf(25));
        MoneyTransferPaymentTransaction.SearchStrategy searchStrategy = new TotalPriceSs(BigDecimal.valueOf(15));
        // when
        History history = new History(Arrays.asList(order, order1));
        // then
        assertEquals(1, history.getOrdersFiltred(searchStrategy).size());
        assertSame(order, history.getOrdersFiltred(searchStrategy).get(0));
    }

    @Test
    void getCompositeOrders() {
        // given
        Product product = mock(Product.class);
        Product product1 = mock(Product.class);
        Product product2 = mock(Product.class);
        Product product3 = mock(Product.class);
        given(product.getName()).willReturn("Strawberry");
        given(product1.getName()).willReturn("Onion");
        given(product2.getName()).willReturn("Lemon");
        given(product3.getName()).willReturn("Apple");
        Order order = mock(Order.class);
        Order order1 = mock(Order.class);
        Order order2 = mock(Order.class);
        given(order.getProducts()).willReturn(Arrays.asList(product, product1, product3));
        given(order1.getProducts()).willReturn(Arrays.asList(product1, product3));
        given(order2.getProducts()).willReturn(Arrays.asList(product, product1, product2, product3));
        given(order.getOrdersBuyer()).willReturn("Nowak");
        given(order1.getOrdersBuyer()).willReturn("Kowalski");
        given(order2.getOrdersBuyer()).willReturn("Nowak");
        given(order.getPriceWithTaxes()).willReturn(BigDecimal.valueOf(25));
        given(order1.getPriceWithTaxes()).willReturn(BigDecimal.valueOf(15));
        given(order2.getPriceWithTaxes()).willReturn(BigDecimal.valueOf(15));
        MoneyTransferPaymentTransaction.SearchStrategy searchStrategy = new CompositeSs(Arrays.asList(
                new ProductSs("Apple"),
                new BuyersSs("Nowak"),
                new TotalPriceSs(BigDecimal.valueOf(15))
        ));

        // when
        History history = new History(Arrays.asList(order, order1, order2));

        // then
        assertEquals(1, history.getOrdersFiltred(searchStrategy).size());
        assertSame(order2, history.getOrdersFiltred(searchStrategy).get(0));
    }

    @Test
    public void searchStrategyNull() {
        // given
        // when
        History history = new History(Arrays.asList(mock(Order.class), mock(Order.class)));
        // then
        assertThrows(NullPointerException.class, () -> history.getOrdersFiltred(null));
    }
}