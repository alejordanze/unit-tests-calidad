package Presentation;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Models.Buyer;

class BuyerMenuTest {

	private InputStream inContent;
	private ByteArrayOutputStream outContent;
	private BuyerMenu buyerMenu;
	LinkedHashMap<String, String> options;
	
    private String getOutput() {
        return outContent.toString();
    }
    
    private void setInput(String input) {
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
    }
    
	@BeforeEach
	public void setUpStreams() {
		outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
        buyerMenu = new BuyerMenu();
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
}