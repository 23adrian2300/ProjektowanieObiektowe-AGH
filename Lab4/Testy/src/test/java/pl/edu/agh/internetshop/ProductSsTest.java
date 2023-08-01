package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.strategy.ProductSs;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ProductSsTest {
    private Order getOrder() {
        Order order = mock(Order.class);
        List<Product> productList = Arrays.asList(
                new Product("Strawberry", BigDecimal.valueOf(23.45), BigDecimal.valueOf(0.2)),
                new Product("Orange", BigDecimal.valueOf(45.85), BigDecimal.valueOf(0.28))
        );
        given(order.getProducts()).willReturn(productList);
        return order;
    }

    @Test
    public void inList() {
        // given
        Order order = getOrder();
        // when
        ProductSs searchStrategy = new ProductSs("Strawberry");
        // then
        assertTrue(searchStrategy.filter(order));
    }

    @Test
    public void notInList() {
        // given
        Order order = getOrder();
        // when
        ProductSs searchStrategy = new ProductSs("Apple");
        // then
        assertFalse(searchStrategy.filter(order));
    }
}