package Models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SoldProductTest {

	private SoldProduct soldProduct = new SoldProduct();
	private SoldProduct soldProductWithConstructor = new SoldProduct("The product is the best on the market",10,2,"Every week");

	@Test
	void getQuantityTest() {
		soldProduct.setQuantity(5);
		assertEquals(5, soldProduct.getQuantity());
	}
	
	@Test
	void getCurrencyTest() {
		soldProduct.setCurrency("Every day");
		assertEquals("Every day",soldProduct.getCurrency());
	}
		
	@Test
	void getSoldDateTest() {
		soldProduct.setSoldDate("12-05-2020");
		assertEquals("12-05-2020",soldProduct.getSoldDate());
	}
	
	@Test
	void toStringSoldProductTest() {
		assertEquals("SoldProduct{description=The product is the best on the market, unitPrice=10.0, quantity=2, currency=Every week}",soldProductWithConstructor.toString());
	}	

}