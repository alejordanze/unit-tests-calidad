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

import Models.SoldProduct;

class ProductMenuTest {

	private InputStream inContent;
	private ByteArrayOutputStream outContent;
	private ProductMenu productMenu;
	
    private String getOutput() {
        return outContent.toString();
    }
    
    private void setInput(String input) {
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        setScan();
    }
    
    private void setScan() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(scanner.next());
        scanner.close();       
    }
    
	@BeforeEach
	public void setUpStreams() {
		outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    productMenu = new ProductMenu();
	}

	@AfterEach
	public void restoreStreams() {
	    System.setIn(System.in);
	    System.setOut(System.out);
	}
	
	@Test
	public void registerMenuTest() {
		String description = "Very good computer for building software";
		String unitPrice = "10";
		String quantity = "2";
		String currency = "Bolivians";
		String enter = "\n";
		String allDataRegisterMenu = description+enter+unitPrice+enter+quantity+enter+currency;
		setInput(allDataRegisterMenu);
	    assertEquals(allDataRegisterMenu, outContent.toString());
//		setInput(unitPrice);
//		SoldProduct soldProduct = productMenu.registerMenu();
//		String expectedDescription = "poiuytrewqasdfghjk";
//	    assertEquals(expectedDescription, soldProduct.getDescription());
//	    assertEquals("hello", outContent.toString());
	}
}
