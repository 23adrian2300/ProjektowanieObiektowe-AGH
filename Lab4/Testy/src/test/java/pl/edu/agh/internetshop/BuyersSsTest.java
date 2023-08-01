package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.strategy.BuyersSs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class BuyersSsTest {

    @Test
    public void sameBuyers() {
        // given
        Order order = mock(Order.class);
        given(order.getOrdersBuyer()).willReturn("Nowak");

        // when
        BuyersSs searchStrategy = new BuyersSs("Nowak");

        // then
        assertTrue(searchStrategy.filter(order));
    }

    @Test
    public void notSameBuyers() {
        // given
        Order order = mock(Order.class);
        given(order.getOrdersBuyer()).willReturn("Kowalski");

        // when
        BuyersSs searchStrategy = new BuyersSs("Nowak");

        // then
        assertFalse(searchStrategy.filter(order));
    }

    @Test
    public void BuyerIsNull() {
        // given
        Order order = mock(Order.class);
        given(order.getOrdersBuyer()).willReturn(null);

        // when
        BuyersSs searchStrategy = new BuyersSs("Nowak");

        // then
        assertFalse(searchStrategy.filter(order));
    }
}