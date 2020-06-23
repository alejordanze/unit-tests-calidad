package Presentation;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuyerMenuTest {

	private InputStream inContent;
	private BuyerMenu buyerMenu =  new BuyerMenu();;
	LinkedHashMap<String, String> options;
	
    private void setInput(String input) {
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
    }
    
	@BeforeEach
	public void setUpStreams() {
		options = new LinkedHashMap<>();
	}

	@AfterEach
	public void restoreStreams() {
	    System.setIn(System.in);
	    System.setOut(System.out);
	}
	
	@Test
	public void isReceiptShowedTrueTest() {
		setInput("9");
		boolean response = buyerMenu.isReceiptShowed();
		assertTrue(response);
	}
	
	@Test
	public void isReceiptShowedFalseTest() {
		setInput("8");
		boolean response = buyerMenu.isReceiptShowed();
		assertFalse(response);
	}
	
	@Test
	public void testShow() {
		LinkedHashMap<String, String> receiptData = new LinkedHashMap<>();
		receiptData.put("FullName", "Miguel Jordan");
		receiptData.put("Ci", "12345678");
		receiptData.put("Email", "mail@mail.com");
		receiptData.put("Address", "Av. Circunvalacion");
		receiptData.put("PaymentMethod", "Money");
		receiptData.put("CreditCardNumber", "");
		receiptData.put("Description", "Pollo entero");
		receiptData.put("Quantity", "1");
		receiptData.put("UnitPrice", "100");
		receiptData.put("Currency", "Bolivians");
		receiptData.put("SoldDate", "12/12/12");
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));
		buyerMenu.show(receiptData);
		assertEquals("Create Date                  12/12/12\n"
				+ "Buyer Details\n"
				+ "\tFull Name                    Miguel Jordan\n"
				+ "\tCI                           12345678\n"
				+ "\tEmail                        mail@mail.com\n"
				+ "\tAddress                      Av. Circunvalacion\n"
				+ "\tPayment Method               Money\n"
				+ "Product Details\n"
				+ "\tProduct Description          Pollo entero\n"
				+ "\tQuantity                     1\n"
				+ "\tUnit Price                   100\n"
				+ "\tCurrency                     Bolivians\n"
				+ "\t                             \n"
				+ "\tTotal                        100.0 Bolivians\n", out.toString());
	}

}