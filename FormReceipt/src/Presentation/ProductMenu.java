/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Models.Interfaces.Menu;
import Models.SoldProduct;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ProductMenu implements Menu<SoldProduct> {

    @Override
    public SoldProduct registerMenu() {
        String description = MenuGenerator.menuValidation(" Enter product description => ", "validateDescription");
        String unitPrice = MenuGenerator.menuValidation(" Enter unit price => ", "validateUnitPrice");
        String quantity = MenuGenerator.menuValidation(" Enter quantity => ", "validateQuantity");
        String currency = currencyOption();
        
        return new SoldProduct(description, Float.parseFloat(unitPrice), Integer.parseInt(quantity), currency);
    }
    
    public String currencyOption() {
        String title = " Select currency option => ";
        ArrayList<String> options = new ArrayList();
        
        options.add("Bolivians");
        options.add("Dollars");
        options.add("Euros");
        
        MenuGenerator.generateMenu(title, options);
        
        int option = MenuGenerator.getOption();
        if(option > 0) {
        	int isValidOption = options.size() - option;
                
	        while (isValidOption < 0) {
	            System.out.print("Please enter a valid option => ");
	            option = MenuGenerator.getOption();
	            isValidOption = options.size() - option;
	        }
        }
        
        String optionMenu = "";
        
        if(option > 0) {
        	optionMenu = options.get(option - 1);
        }
        
        return optionMenu;
    }
}
