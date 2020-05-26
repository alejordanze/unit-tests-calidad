package Utilities;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

class JsonObjectTest {
	
	private JsonObject jsonObject = new JsonObject(); 

	

	@Test
	void testSaveJsonFile() throws IOException {
		assertTrue(jsonObject.saveJsonFile("prueba"));
	}

	@Test
	void testAddPairToJson() {
		jsonObject.addPairToJson("llave", "valor");
		

	}

	@Test
	void testGetJsonFile() throws FileNotFoundException, Exception {
		JsonObject json = new JsonObject(); 
		assertEquals(jsonObject.getJsonFile(null),json.getJsonFile("prueba"));
	}

	@Test
	void testSize() {
		assertSame(0, jsonObject.size());
	}

}
