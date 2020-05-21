package Models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BuyerTest {

	Buyer buyer;

	@BeforeEach
	void setUp() {
		buyer = new Buyer("Miguel Jordan","12345678", "mail@mail.com", "Av. America", "Money", "123456");
	}
	
	@Test
	public void constructorTest() {
		// String fullName, String ci, String email, String address, String paymentMethod, String creditCardNumber
		buyer = new Buyer();
		buyer.setCreditCardNumber("123");
		assertEquals("123",buyer.getCreditCardNumber());
	}
	
	@Test
	public void getPaymentMethodTest() {
		assertEquals("Money", buyer.getPaymentMethod());
	}
	
	@Test
	public void setPaymentMethodTest() {
		buyer.setPaymentMethod("Transfer");
		assertEquals("Transfer", buyer.getPaymentMethod());
	}
	
	@Test
	public void getCreditCardNumberTest() {
		assertEquals("123456", buyer.getCreditCardNumber());
	}
	
	@Test
	public void setCreditCardNumberTest() {
		buyer.setCreditCardNumber("12345678");
		assertEquals("12345678", buyer.getCreditCardNumber());
	}
	
	
	@Test
	public void getToStringTest() {
		assertEquals("Buyer{" + "fullName=" + "Miguel Jordan" + ", ci=" + "12345678" + 
			    ", email=" + "mail@mail.com" + ", address=" + "Av. America" + " paymentMethod=" + 
			    "Money" + ", creditCardNumber=" + "123456" + '}', buyer.toString());
			    
	}
}
