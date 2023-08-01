package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

public class OrderTest {
	private Order getOrderMockedProduct() {
		Product product = mock(Product.class);
		return new Order(Collections.singletonList(product));
	}

	@Test
	public void getPrice() throws Exception {
		// given
		BigDecimal expectedProductPrice = BigDecimal.valueOf(1500);
		Product product = mock(Product.class);
		given(product.getPrice()).willReturn(expectedProductPrice);
		Order order = new Order(Collections.singletonList(product));

		// when
		BigDecimal actualProductPrice = order.getPrice();

		// then
		assertBigDecimalCompareValue(expectedProductPrice, actualProductPrice);
	}

	@Test
	public void getPriceWithProductDiscount() {
		// given
		Product product = mock(Product.class);
		Product product1 = mock(Product.class);

		BigDecimal expectedOrderPrice = BigDecimal.valueOf(1.8);

		given(product.getPriceWithDiscount()).willReturn(BigDecimal.valueOf(0.95));
		given(product1.getPriceWithDiscount()).willReturn(BigDecimal.valueOf(0.85));

		// when
		Order order = new Order(Arrays.asList(product, product1));

		// then
		assertBigDecimalCompareValue(expectedOrderPrice, order.getPriceWithProductDiscount());
	}

	@Test
	public void getPriceWithDiscount() {
		// given
		Product product = mock(Product.class);
		Product product1 = mock(Product.class);

		BigDecimal expectedOrderPrice = BigDecimal.valueOf(1.62);

		given(product.getPriceWithDiscount()).willReturn(BigDecimal.valueOf(0.9));
		given(product1.getPriceWithDiscount()).willReturn(BigDecimal.valueOf(0.9));
		// when
		Order order = new Order(Arrays.asList(product, product1));
		order.setDiscount(BigDecimal.valueOf(0.1));

		// then
		assertBigDecimalCompareValue(expectedOrderPrice, order.getPriceWithDiscount());
	}

	@Test
	public void getPriceWithTaxes() {
		Product product = mock(Product.class);
		Product product1 = mock(Product.class);
		BigDecimal expectedOrderPrice = BigDecimal.valueOf(1.88);
		given(product.getPriceWithDiscount()).willReturn(BigDecimal.valueOf(0.9));
		given(product1.getPriceWithDiscount()).willReturn(BigDecimal.valueOf(0.8));
		// when
		Order order = new Order(Arrays.asList(product, product1));
		order.setDiscount(BigDecimal.valueOf(0.1));

		// then
		assertBigDecimalCompareValue(expectedOrderPrice, order.getPriceWithTaxes());
	}

	@Test
	public void getPriceWithTaxesWithoutRoundUp() {
		// given
		Product product = mock(Product.class);

		// when
		Order order = new Order(Collections.singletonList(product));
		given(product.getPriceWithDiscount()).willReturn(BigDecimal.valueOf(2));
		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(2.46));
	}

	@Test
	public void getPriceWithTaxesWithRoundDown() {
		// given
		Product product = mock(Product.class);
		// when
		Order order = new Order(Collections.singletonList(product));
		given(product.getPriceWithDiscount()).willReturn(BigDecimal.valueOf(0.01));
		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(0.01));
	}

	@Test
	public void getPriceWithTaxesWithRoundUp() {
		// given
		BigDecimal productPrice = BigDecimal.valueOf(0.03);
		Product product = mock(Product.class);
		given(product.getPrice()).willReturn(productPrice);
		given(product.getPriceWithDiscount()).willReturn(productPrice);
		// when
		Order order = new Order(Collections.singletonList(product));
		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(0.04));
	}

	@Test
	public void getPriceMultiplyProducts() {
		// given
		Product product = mock(Product.class);
		Product product1 = mock(Product.class);

		BigDecimal expectedProductPrice = BigDecimal.valueOf(1500);

		given(product.getPrice()).willReturn(BigDecimal.valueOf(1250));
		given(product1.getPrice()).willReturn(BigDecimal.valueOf(250));
		// when
		Order order = new Order(Arrays.asList(product, product1));
		// then
		assertBigDecimalCompareValue(expectedProductPrice, order.getPrice());
	}

	@Test
	public void sending() {
		// given
		Order order = getOrderMockedProduct();
		SurfaceMailBus surface = mock(SurfaceMailBus.class);
		Shipment shipment = mock(Shipment.class);
		given(shipment.isShipped()).willReturn(true);
		// when
		order.setShipmentMethod(surface);
		order.setShipment(shipment);
		order.send();
		// then
		assertTrue(order.isSent());
	}

	@Test
	public void isSentWithoutSending() {
		// given
		Order order = getOrderMockedProduct();
		Shipment shipment = mock(Shipment.class);
		given(shipment.isShipped()).willReturn(true);
		// when
		// then
		assertFalse(order.isSent());
	}

	@Test
	public void paying() throws Exception {
		// given
		Order order = getOrderMockedProduct();
		PaymentMethod paymentMethod = mock(MoneyTransferPaymentTransaction.class);
		given(paymentMethod.commit(any(MoneyTransfer.class))).willReturn(true);
		MoneyTransfer moneyTransfer = mock(MoneyTransfer.class);
		given(moneyTransfer.isCommitted()).willReturn(true);
		// when
		order.setPaymentMethod(paymentMethod);
		order.pay(moneyTransfer);

		// then
		assertTrue(order.isPaid());
	}

	@Test
	public void isPaidWithoutPaying() throws Exception {
		// given
		Order order = getOrderMockedProduct();
		// when
		// then
		assertFalse(order.isPaid());
	}

	@Test
	public void setShipment() throws Exception {
		// given
		Order order = getOrderMockedProduct();
		Shipment expectedShipment = mock(Shipment.class);
		// when
		order.setShipment(expectedShipment);
		// then
		assertSame(expectedShipment, order.getShipment());
	}

	@Test
	public void getShipmentWithoutSetting() throws Exception {
		// given
		Order order = getOrderMockedProduct();
		// when
		// then
		assertNull(order.getShipment());
	}

	@Test
	public void setDiscount() throws Exception {
		// given
		Order order = getOrderMockedProduct();
		BigDecimal expectedDiscount = BigDecimal.valueOf(0.05);
		// when
		order.setDiscount(expectedDiscount);
		// then
		assertBigDecimalCompareValue(expectedDiscount, order.getDiscount());
	}

	@Test
	public void getDiscountWithoutSetting() throws Exception {
		// given
		Order order = getOrderMockedProduct();
		// when
		// then
		assertNull(order.getDiscount());
	}

	@Test
	public void setOrdersBuyers() throws Exception {
		// given
		Order order = getOrderMockedProduct();
		String wantSurname = "Nowak";

		// when
		order.setOrdersBuyers(wantSurname);

		// then
		assertEquals(wantSurname, order.getOrdersBuyer());
	}

	@Test
	public void getOrdersBuyersWithoutSetting() throws Exception {
		// given
		Order order = getOrderMockedProduct();
		// when
		// then
		assertNull(order.getOrdersBuyer());
	}

	@Test
	public void setPaymentMethod() throws Exception {
		// given
		Order order = getOrderMockedProduct();
		PaymentMethod paymentMethod = mock(MoneyTransferPaymentTransaction.class);
		// when
		order.setPaymentMethod(paymentMethod);
		// then
		assertSame(paymentMethod, order.getPaymentMethod());
	}

	@Test
	public void getPaymentMethodWithoutSetting() throws Exception {
		// given
		Order order = getOrderMockedProduct();
		// when
		// then
		assertNull(order.getPaymentMethod());
	}

	@Test
	public void setShipmentMethod() {
		// given
		Order order = getOrderMockedProduct();
		ShipmentMethod surface = mock(SurfaceMailBus.class);
		// when
		order.setShipmentMethod(surface);
		// then
		assertSame(surface, order.getShipmentMethod());
	}

	@Test
	public void getShipmentMethodWithoutSetting() {
		// given
		Order order = getOrderMockedProduct();
		// when
		// then
		assertNull(order.getShipmentMethod());
	}

	@Test
	public void whetherIdExists() throws Exception {
		// given
		Order order = getOrderMockedProduct();
		// when
		// then
		assertNotNull(order.getId());
	}

	@Test
	public void productsListIsNull() {
		// when then
		assertThrows(NullPointerException.class, () -> new Order(null));
	}

	@Test
	public void listProductIsNull() {
		// given
		List<Product> products = Arrays.asList(mock(Product.class), null);
		// when then
		assertThrows(NullPointerException.class, () -> new Order(products));
	}

	@Test
	public void getProductThroughOrder() {
		// given
		Product expectedProduct = mock(Product.class);
		Order order = new Order(Collections.singletonList(expectedProduct));
		// when
		List<Product> actualProducts = order.getProducts();
		// then
		assertSame(expectedProduct, actualProducts.get(0));
	}

	@Test
	public void getMultipleProductFromOrder() {
		// given
		Product expectedProduct = mock(Product.class);
		Product expectedProduct1 = mock(Product.class);

		// when
		Order order = new Order(Arrays.asList(expectedProduct, expectedProduct1));

		// then
		assertSame(expectedProduct, order.getProducts().get(0));
		assertSame(expectedProduct1, order.getProducts().get(1));
		assertEquals(order.getProducts().size(), order.getProducts().size());
	}
}