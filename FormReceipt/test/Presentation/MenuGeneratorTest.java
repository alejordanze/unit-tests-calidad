package Presentation;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

import org.junit.jupiter.api.*;

class MenuGeneratorTest {
	
	private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
	MenuGenerator menuGenerator;
	ArrayList<String> options = new ArrayList<>();
	LinkedHashMap<String, String> options2 = new LinkedHashMap<>();
	
	void autoInput(String input) {
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	}
	
	@BeforeEach
	void SetUp() {
		System.setIn(systemIn);
        System.setOut(systemOut);
		options2.put("Name","Name");
		options2.put("Age","Age");
		options.add("Name");
		options.add("Age");
		
//		menuGenerator = new MenuGenerator();
	}
	
	@Test
	void testGenerateMenuMap() {
		MenuGenerator.generateMenu("Menu", options);
		MenuGenerator.generateInformationSection(options2);
		MenuGenerator.generateMenu("Menu", options2);
		MenuGenerator.generateInformationSection("Menu", options2);
		autoInput("2\n");
		int response = MenuGenerator.getOption();
		assertEquals(2, response);
	}
	
	@Test
	void testMenuValidation() {
		autoInput("s\n1\n");
		String response = MenuGenerator.menuValidation("Cantidad: ","validateQuantity");
		assertEquals("1", response);	
	}
}
