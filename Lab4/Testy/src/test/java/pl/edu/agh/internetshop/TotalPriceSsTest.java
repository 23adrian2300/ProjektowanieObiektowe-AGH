package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.strategy.TotalPriceSs;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class TotalPriceSsTest {
    private Order getOrder() {
        Order order = mock(Order.class);
        given(order.getPriceWithTaxes()).willReturn(BigDecimal.valueOf(15));
        return order;
    }

    @Test
    public void sameTotalPrice() {
        // given
        Order order = getOrder();
        // when
        TotalPriceSs searchStrategy = new TotalPriceSs(BigDecimal.valueOf(15));
        // then
        assertTrue(searchStrategy.filter(order));
    }

    @Test
    public void notSameTotalPrice() {
        // given
        Order order = getOrder();
        // when
        TotalPriceSs searchStrategy = new TotalPriceSs(BigDecimal.valueOf(9));
        // then
        assertFalse(searchStrategy.filter(order));
    }
}