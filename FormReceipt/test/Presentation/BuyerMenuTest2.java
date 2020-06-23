package Presentation;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class BuyerMenuTest2 {
	
	private InputStream inContent;
	private BuyerMenu buyerMenu =  new BuyerMenu();;
	LinkedHashMap<String, String> options;
	
    private void setInput(String input) {
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
    }

	@AfterEach
	public void restoreStreams() {
	    System.setIn(System.in);
	    System.setOut(System.out);
	}
	
	@Test
	public void testCi() {
		setInput("1\n");
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));
		buyerMenu.getExtensionCI();
		assertEquals(" Select the extension CI => \n" + 
				"---------------------------\n" + 
				"	1.- BNI\n" + 
				"	2.- CHQ\n" + 
				"	3.- CBBA\n" + 
				"	4.- LPZ\n" + 
				"	5.- ORU\n" + 
				"	6.- PND\n" + 
				"	7.- PSI\n" + 
				"	8.- SCZ\n" + 
				"	9.- TJA\n" + 
				"Choose a options => option entered: 1\n", out.toString());
	}
	
	@Test 
	public void testPayment() {
		setInput("1\n");
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));
		buyerMenu.paymentOption();
		assertEquals(" Select payment method => \n" + 
				"---------------------------\n" + 
				"	1.- Cash\n" + 
				"	2.- Credit Card\n" +
				"Choose a options => option entered: 1\n", out.toString());
	}

}
