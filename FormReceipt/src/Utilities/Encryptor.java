/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author ASUS
 */
public class Encryptor {
    private static final String key = "Bar12345Bar54321";
    
    public static String encryptValue(String valueDecrypted) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] encrypted = cipher.doFinal(valueDecrypted.getBytes());
        String encoded = Base64.getEncoder().encodeToString(encrypted);
        
        return encoded;
    }
    
    public static String decryptValue(String valueEncrypted) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] decoded = Base64.getDecoder().decode(valueEncrypted);
        Cipher cipher = Cipher.getInstance("AES");
        Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
        
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        String decrypted = new String(cipher.doFinal(decoded));
        
        return decrypted;
    }
}