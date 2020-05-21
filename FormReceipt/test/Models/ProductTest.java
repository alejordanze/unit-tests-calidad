package Models;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ProductTest {
		
	private Product product = new Product();
	private Product productWithConstructor = new Product("The product is the best on the market",10);

	@Test
	void getUnitPriceTest() {
		product.setUnitPrice(5);
		assertEquals(5, product.getUnitPrice());
	}
	
	@Test
	void getDescriptionTest() {
		product.setDescription("The product has the best mark and prime materia");
		assertEquals("The product has the best mark and prime materia",product.getDescription());
	}
	
	@Test
	void toStringProductTest() {
		assertEquals("Product{unitPrice=10.0, description=The product is the best on the market}",productWithConstructor.toString());
	}
}