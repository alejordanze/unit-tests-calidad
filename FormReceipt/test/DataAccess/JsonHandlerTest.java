package DataAccess;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.junit.jupiter.api.*;

import Models.Buyer;
import Models.Interfaces.ObjectHandler;
import Utilities.JsonObject;


class JsonHandlerTest {
	
	JsonHandler<Buyer> jsonHandler;
	ObjectHandler jsonObject;
	Buyer  buyer;

	@BeforeEach
	void setUp() {
		jsonObject = new JsonObject();
		buyer = new Buyer("Miguel Jordan","12345678", "mail@mail.com", "Av. America", "Cash", "");
	}
	
	@Test
	void testCreateEmptyFile() throws IOException {
		jsonHandler = new JsonHandler<Buyer>(jsonObject);
		assertEquals(true, jsonHandler.createFile("file"));
	}
	
	@Test
	void testGetEmptyFile() throws Exception {
		jsonHandler = new JsonHandler<Buyer>(jsonObject);
		LinkedHashMap<String, String> mapValues = new LinkedHashMap<>();
		assertEquals(mapValues, jsonHandler.getFile("file"));
	}
	
	@Test
	void testAddToMap() throws Exception {
		jsonHandler = new JsonHandler<Buyer>(jsonObject);
		assertTrue(jsonHandler.addToMap(buyer));
	}
	
	@Test
	void testCreateFile() throws Exception {
		jsonHandler = new JsonHandler<Buyer>(jsonObject);
		jsonHandler.addToMap(buyer);
		assertTrue(jsonHandler.createFile("file2"));
	}
	
	@Test
	void testGetFile() throws Exception {
		jsonHandler = new JsonHandler<Buyer>(jsonObject);
		LinkedHashMap<String, String> mapValues = getMap();
		assertEquals(mapValues, jsonHandler.getFile("file2"));
	}
	
	LinkedHashMap<String, String> getMap(){
		LinkedHashMap<String, String> mapValues = new LinkedHashMap<>();
		mapValues.put("Email", buyer.getEmail());
		mapValues.put("Address", buyer.getAddress());
		mapValues.put("Ci", buyer.getCi());
		mapValues.put("FullName", buyer.getFullName());
		mapValues.put("PaymentMethod", buyer.getPaymentMethod());
		mapValues.put("CreditCardNumber", buyer.getCreditCardNumber());
		return mapValues;
	}


}
