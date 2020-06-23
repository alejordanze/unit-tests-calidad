package Presentation;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductMenuTest {

	private ProductMenu productMenu;
    
	void autoInput(String input) {
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	}
	
	@BeforeEach
	public void setUpStreams() {
	
	    productMenu = new ProductMenu();
	}
	
	@Test
	public void currencyOptionTest() {
		autoInput("1\n");
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));
		this.productMenu.currencyOption();
		assertEquals(" Select currency option => \n" + 
				"---------------------------\n" + 
				"	1.- Bolivians\n" + 
				"	2.- Dollars\n" + 
				"	3.- Euros\n" + 
				"Choose a options => option entered: 1\n", out.toString());
	}
}
