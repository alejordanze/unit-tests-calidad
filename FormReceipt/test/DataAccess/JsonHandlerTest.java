package DataAccess;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.*;
import org.skyscreamer.jsonassert.JSONAssert;

import Models.Buyer;
import Models.Interfaces.ObjectHandler;
import Utilities.JsonObject;


class JsonHandlerTest {
	
	JsonHandler jsonHandler;
	ObjectHandler jsonObject;
	Buyer  buyer;

	@BeforeEach
	void setUp() {
		jsonHandler = new JsonHandler();
		jsonObject = new JsonObject();
		buyer = new Buyer("Miguel Jordan","12345678", "mail@mail.com", "Av. America", "Cash", "");
	}
	
	@Test
	void testCreateEmptyFile() throws IOException {
		jsonHandler = new JsonHandler(jsonObject);
		assertEquals(true, jsonHandler.createFile("file"));
	}
	
	@Test
	void testGetEmptyFile() throws Exception {
		LinkedHashMap<String, String> mapValues = new LinkedHashMap<>();
		assertEquals(mapValues, jsonHandler.getFile("file"));
	}
	
	@Test
	void testCreateFile() throws Exception {
		assertEquals(true, jsonHandler.addToMap(buyer));
		assertEquals(true, jsonHandler.createFile("file2"));
	}
	
	@Test
	void testGetFile() throws Exception {
		jsonHandler = new JsonHandler(jsonObject);
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
