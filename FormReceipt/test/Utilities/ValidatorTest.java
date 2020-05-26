package Utilities;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class ValidatorTest {

	Validator validator;
	
	@BeforeEach 
	void setUp() {
		String[] options = {"validateFullName","validateCiNumber","validateEmail","validateAddress","verifyCreditCard","validateDescription","validateUnitPrice","validateQuantity"};
		validator = new Validator();
	}
	@Test
	void testCiNumberCorrect() {
		assertEquals("", validator.validateCiNumber("12345678"));
	}
	
	@Test
	void testCiNumberLetters() {
		assertEquals("The field must have only integer numbers", validator.applyValidation("123s4567","validateCiNumber"));
	}

	
	@Test
	void testCiNumberShort() {
		assertEquals("The field should be between 6 and 10 characters", validator.applyValidation("123","validateCiNumber"));
	}
	
	@Test
	void testEmailCorrect() {
		assertEquals("", validator.applyValidation("mail@mail.com","validateEmail"));
	}
	
	@Test
	void testEmailIncorrect() {
		assertEquals("The email is incorrect, e.g. example@gmail.com", validator.applyValidation("mail@mail","validateEmail"));
	}
	
	@Test
	void testFullNameCorrect() {
		assertEquals("", validator.applyValidation("Miguel Jordan","validateFullName"));
	}
	
	@Test
	void testFullNameNumbers() {
		assertEquals("The field must have only letters", validator.applyValidation("Miguel 123","validateFullName"));
	}
	
	@Test
	void testFullNameShort() {
		assertEquals("The field should be between 10 and 100 characters", validator.applyValidation("123","validateFullName"));
	}
	
	@Test
	void testCreditCardCorrect() {
		assertEquals("", validator.applyValidation("1234-1235-1234-1234","verifyCreditCard"));
	}
	
	@Test
	void testCreditCardIncorrect() {
		assertEquals("The credit card is incorrect e.g. xxxx-xxxx-xxxx-xxxx", validator.applyValidation("1234-1235-1234-123","verifyCreditCard"));
	}
	
	@Test
	void testUnitPrice() {
		assertEquals("", validator.applyValidation("10.5", "validateUnitPrice"));
	}
	
	@Test
	void testUnitPriceInt() {
		assertEquals("The field must have only integer or decimal numbers", validator.applyValidation("10.123", "validateUnitPrice"));
	}
	
	@Test
	void testQuantity() {
		assertEquals("",validator.applyValidation("1", "validateQuantity"));
	}
	
	@Test
	void testQuantityIncorrect() {
		assertEquals("The field must have only integer numbers",validator.applyValidation("1.4", "validateQuantity"));
	}
	
	@Test
	void testAddress() {
		assertEquals("",validator.applyValidation("Av. America", "validateAddress"));
	}
	
	@Test
	void testAddressIncorrect() {
		assertEquals("The field should be between 10 and 100 characters",validator.applyValidation("Av", "validateAddress"));
	}
	
	@Test
	void testDescription() {
		assertEquals("",validator.applyValidation("Pollo entero", "validateDescription"));
	}
	
	@Test
	void testDescriptionIncorrect() {
		assertEquals("The field should be between 10 and 100 characters",validator.applyValidation("Pollo", "validateDescription"));
	}
}
