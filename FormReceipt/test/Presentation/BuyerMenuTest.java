package Presentation;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Models.Buyer;

class BuyerMenuTest {

	private InputStream inContent;
	private ByteArrayOutputStream outContent;
	private BuyerMenu buyerMenu;
	
    private String getOutput() {
        return outContent.toString();
    }
    
    private void setInput(String input) {
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        setScan();
    }
    
    
//    private void setInputInt(Int input) {
//        inContent = new InputStream(input);
//        System.setIn(inContent);
//        setScan();
//    }
        
    private void setScan() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(scanner.next());
        scanner.close();       
    }
    
	@BeforeEach
	public void setUpStreams() {
		outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
        buyerMenu = new BuyerMenu();
	}

	@AfterEach
	public void restoreStreams() {
	    System.setIn(System.in);
	    System.setOut(System.out);
	}
	
	@Test
	void test() {
        String testString = "Hello!";
        setInput(testString);   
        assertEquals(testString, getOutput());
	}

//	@Test
//	public void registerMenuTest() {
//        String fullname = "Ivy Sejas";
//        String ci = "123456789";
//        String extensionCI = "CBBA";
//        String email = "ivysejas@gmail.com";
//        String address = "Av. Calampampa";
//        String paymentMethod = "Cash"; 
//        String creditCardNumber = "";
//        
//        String expectedFullname;
//        String expectedCi;
//        String expectedExtensionCI;
//        String expectedEmail;
//        String expectedAddress;
//        String expectedPaymentMethod;
//        String expectedCreditCardNumber;
//        
//	    System.out.print("hello");
//	    assertEquals("hello", outContent.toString());
	
	
//	}
	
	@Test
	public void paymentOptionTest() {
		String fullName = "Saskia Sejas";
		String completeCI = "123467 - CBBA";
		String email="saskiasejas@gmail.com";
		String adress = "Av. Calampampa";
		String paymentMethod = "Cash";
        String creditCardNumber = "";
		String enter = "\n";
		String allDataRegisterMenu = fullName+enter+completeCI+enter+email+enter+adress+enter+paymentMethod+enter+creditCardNumber;
		setInput(allDataRegisterMenu);
//	    assertEquals("hello", outContent.toString());
		Buyer buyer = buyerMenu.registerMenu();

		assertEquals(fullName, buyer.getFullName());
//		assertEquals(completeCI, buyer.getCi());
//		assertEquals(email, buyer.getEmail());
//		assertEquals(adress, buyer.getAddress());
//		assertEquals(paymentMethod,buyer.getPaymentMethod());
//		assertEquals(creditCardNumber,buyer.getPaymentMethod());

	}
}