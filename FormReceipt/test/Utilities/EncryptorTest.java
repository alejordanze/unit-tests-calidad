package Utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EncryptorTest {

	Encryptor encryptor; 
	@BeforeEach 
	void setUp() {
		encryptor = new Encryptor();
	}
	
	@Test
	void encryptValueTest() throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException {
        String encriptValue = encryptor.encryptValue("9876-5432-1987-6543");
		assertEquals("Ubmdw6Yk3y4XwxF8IFgmFkUJfi9RwpU674NUS30SMkA=", encriptValue);
	}
	
	@Test
	void decryptValueTest() throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException {
        String decryptValue = encryptor.decryptValue("Ubmdw6Yk3y4XwxF8IFgmFkUJfi9RwpU674NUS30SMkA=");
		assertEquals("9876-5432-1987-6543", decryptValue);
	}

}
