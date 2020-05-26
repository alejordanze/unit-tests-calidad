package Presentation;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import org.junit.jupiter.api.*;

class MenuGeneratorTest {

	MenuGenerator menuGenerator;
	ArrayList<String> options;
	LinkedHashMap<String, String> options2;
	
	void autoInput(String input) {
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	}
	
	@BeforeEach
	void SetUp() {
		InputStream sysInBackup = System.in;
		menuGenerator = new MenuGenerator();
		options = new ArrayList<>();
		options.add("Name");
		options.add("Age");
		options2 = new LinkedHashMap<>();
		options2.put("Name","Name");
		options2.put("Age","Age");
		System.setIn(sysInBackup);
	}
	
	@Test
	void testGenerateMenu() {
		menuGenerator.generateMenu("Menu", options);
		menuGenerator.generateInformationSection("Menu",options2);
		autoInput("2");
		assertEquals(2, menuGenerator.getOption());
	}
	
	@Test
	void testGenerateMenuMap() {
		menuGenerator.generateMenu("Menu", options2);
		menuGenerator.generateInformationSection(options2);
		autoInput("2");
		assertEquals(2, menuGenerator.getOption());
	}
	
	@Test
	void testMenuValidation() {
		//Must input s then input 1
		String response = menuGenerator.menuValidation("Cantidad: ","validateQuantity");
		assertEquals("1", response);	
	}
}
