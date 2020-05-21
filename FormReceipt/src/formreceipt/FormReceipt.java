/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formreceipt;

import BusinessLogic.Seller;
import Models.Buyer;
import Models.SoldProduct;
import Presentation.BuyerMenu;
import Presentation.ProductMenu;
import java.util.LinkedHashMap;

/**
 *
 * @author ASUS
 */
public class FormReceipt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BuyerMenu buyerMenu = new BuyerMenu();
            Buyer buyer = buyerMenu.registerMenu();
            
            ProductMenu productMenu = new ProductMenu();
            System.out.println("--------------------------");
            SoldProduct soldProduct = productMenu.registerMenu();
            
            Seller seller = new Seller();
            boolean isSaved = seller.saveReceipt(buyer, soldProduct);
            if (isSaved) {
                System.out.println("Receipt was stored successfully.");
                boolean isReceiptShowed = buyerMenu.isReceiptShowed();
                if (isReceiptShowed) {
                    LinkedHashMap<String, String> receiptData = seller.getReceipt(buyer.getFullName());
                    buyerMenu.show(receiptData);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}