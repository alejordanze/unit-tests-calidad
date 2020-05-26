package Models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class UserTest {

	private User user = new User();
	private User userWithConstructor = new User("Jorge Diaz", "1234567","jorge@mail.com","av. america #222");

	@Test
	void getFullNameTest() {
		user.setFullName("Ana Lopez");
		assertEquals("Ana Lopez", user.getFullName());
	}
	
	@Test
	void getCiTest() {
		user.setCi("1234567");
		assertEquals("1234567",user.getCi());
	}
	
	@Test
	void getEmailTest() {
		user.setEmail("jorge@mail.com");
		assertEquals("jorge@mail.com",user.getEmail());
	}
	
	@Test
	void getAddressTest() {
		user.setAddress("av. beijing");
		assertEquals("av. beijing",user.getAddress());
	}
	
	@Test
	void toStringUserTest() {
		assertEquals("User{fullName=Jorge Diaz, ci=1234567, email=jorge@mail.com, address=av. america #222}",userWithConstructor.toString());
	}
}
