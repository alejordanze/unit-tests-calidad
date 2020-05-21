/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.JsonHandler;
import Models.Buyer;
import Models.Interfaces.Client;
import Models.Interfaces.FileHandler;
import Models.SoldProduct;
import Utilities.Encryptor;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 *
 * @author ASUS
 */
public class Seller implements Client<Buyer, SoldProduct>{
    private FileHandler jsonHandler;
    
    public Seller() {
        this.jsonHandler = new JsonHandler();
    }
    
    public Seller(FileHandler fileHandler) {
        this.jsonHandler = fileHandler;
    }
    
    /**
     *
     * @param buyer
     * @param soldProduct
     * @return 
     * @throws java.io.IOException 
     * @throws java.security.GeneralSecurityException 
     */
    @Override
    public boolean saveReceipt(Buyer buyer, SoldProduct soldProduct) throws IOException, GeneralSecurityException, Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date currentDate = new Date();
        String stringDate = formatter.format(currentDate);  
        soldProduct.setSoldDate(stringDate);
        
        String creditCard = buyer.getCreditCardNumber();
        
        if (!creditCard.isEmpty()) {
            String encriptValue = Encryptor.encryptValue(creditCard);
            buyer.setCreditCardNumber(encriptValue);
        }
        
        this.jsonHandler.addToMap(buyer);
        this.jsonHandler.addToMap(soldProduct);
        this.jsonHandler.createFile(buyer.getFullName());
        
        return true;
    }
    
    @Override
    public LinkedHashMap<String, String> getReceipt(String fullName) throws Exception {
        LinkedHashMap<String, String> jsonMap = this.jsonHandler.getFile(fullName);
        String creditCard = jsonMap.get("CreditCardNumber");
        
        if (!creditCard.isEmpty()) {
            String decryptValue = Encryptor.decryptValue(creditCard);
            String lastFourDigits = decryptValue.substring(decryptValue.length() - 4);
            String hiddenDigits = decryptValue.substring(0, decryptValue.length() - 4);
            hiddenDigits = hiddenDigits.replaceAll("[0-9]", "X");
            String creditCardNumber = hiddenDigits.concat(lastFourDigits);
            jsonMap.put("CreditCardNumber", creditCardNumber);
        }
        
        return jsonMap;
    }
}
