/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Models.Buyer;
import Models.Interfaces.Menu;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 *
 * @author ASUS
 */
public class BuyerMenu implements Menu<Buyer> {
    @Override
    public Buyer registerMenu() {
        String fullname = MenuGenerator.menuValidation(" Enter full name => ", "validateFullName");
        String ci = MenuGenerator.menuValidation(" Enter CI number => ", "validateCiNumber");
        String extensionCI = getExtensionCI();
        ci = ci + " - " + extensionCI;
        String email = MenuGenerator.menuValidation(" Enter email => ", "validateEmail");
        String address = MenuGenerator.menuValidation(" Enter address => ", "validateAddress");
        String paymentMethod = paymentOption();
        String creditCardNumber = "";
        
        switch(paymentMethod) {
            case "Credit Card":
                creditCardNumber = MenuGenerator.menuValidation(" Enter credit card number => ", "verifyCreditCard");
                break;
            default:
                break;
        }
        
        return new Buyer(fullname, ci, email, address, paymentMethod, creditCardNumber);
    }
    
    public boolean isReceiptShowed() {
        LinkedHashMap<String, String> options = new LinkedHashMap<>();
        String title = "";
        options.put("9", "Press 9 if you want to see the Receipt Summary");
        
        MenuGenerator.generateMenu(title, options);
        
        int option = MenuGenerator.getOption();
        
        return option == 9;
    }
    
    public void show(LinkedHashMap<String, String> receiptData) {
        LinkedHashMap<String, String> createDateSection = new LinkedHashMap<>();
        String soldDate = receiptData.get("SoldDate");
        createDateSection.put("Create Date", soldDate);
        MenuGenerator.generateInformationSection(createDateSection);

        String titleBuyersDetailSection = "Buyer Details";
        LinkedHashMap<String, String> buyersDetailSection = new LinkedHashMap<>();
        String fullname = receiptData.get("FullName");
        String ci = receiptData.get("Ci");
        String email = receiptData.get("Email");
        String address = receiptData.get("Address");
        String paymentMethod = receiptData.get("PaymentMethod");

        buyersDetailSection.put("Full Name", fullname);
        buyersDetailSection.put("CI", ci);
        buyersDetailSection.put("Email", email);
        buyersDetailSection.put("Address", address);
        buyersDetailSection.put("Payment Method", paymentMethod);

        if (!receiptData.get("CreditCardNumber").isEmpty()) {
            String creditCardNumber = receiptData.get("CreditCardNumber");
            buyersDetailSection.put("Credit Card Number", creditCardNumber);
        }
        
        MenuGenerator.generateInformationSection(titleBuyersDetailSection, buyersDetailSection);
        
        String titleProductDetailSection = "Product Details";
        LinkedHashMap<String, String> productDetailSection = new LinkedHashMap<>();
        String description = receiptData.get("Description");
        String quantity = receiptData.get("Quantity");
        String unitPrice = receiptData.get("UnitPrice");
        String currency = receiptData.get("Currency");

        productDetailSection.put("Product Description", description);
        productDetailSection.put("Quantity", quantity);
        productDetailSection.put("Unit Price", unitPrice);
        productDetailSection.put("Currency", currency);
        productDetailSection.put("", "");
        
        String total = Float.toString(Integer.parseInt(quantity) * Float.parseFloat(unitPrice)) + " " + currency;
        productDetailSection.put("Total", total);
        
        MenuGenerator.generateInformationSection(titleProductDetailSection, productDetailSection);
    }
    
    public String getExtensionCI() {
        String title = " Select the extension CI => ";
        
        ArrayList<String> options = new ArrayList();
        
        options.add("BNI");
        options.add("CHQ");
        options.add("CBBA");
        options.add("LPZ");
        options.add("ORU");
        options.add("PND");
        options.add("PSI");
        options.add("SCZ");
        options.add("TJA");
        
        MenuGenerator.generateMenu(title, options);
        
        int option = MenuGenerator.getOption();
        int isValidOption = options.size() - option;
                
        while (isValidOption < 0) {
            System.out.print("Please enter a valid option => ");
            option = MenuGenerator.getOption();
            isValidOption = options.size() - option;
        }
        
        String optionMenu = options.get(option - 1);
        
        return optionMenu;
    }
    
    public String paymentOption() {
        String title = " Select payment method => ";
        ArrayList<String> options = new ArrayList();
        
        options.add("Cash");
        options.add("Credit Card");
        
        MenuGenerator.generateMenu(title, options);
        
        int option = MenuGenerator.getOption();
        int isValidOption = options.size() - option;
                
        while (isValidOption < 0) {
            System.out.print("Please enter a valid option => ");
            option = MenuGenerator.getOption();
            isValidOption = options.size() - option;
        }
        
        String optionMenu = options.get(option - 1);
        
        return optionMenu;
    }
}