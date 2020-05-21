/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author ASUS
 */
public class SoldProduct extends Product {
    private int quantity;
    private String currency;
    private String soldDate;
    
    public SoldProduct() {
        super();
    }
    
    public SoldProduct(String description, float unitPrice, int quantity, String currency) {
        super(description, unitPrice);
        this.quantity = quantity;
        this.currency = currency;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(String soldDate) {
        this.soldDate = soldDate;
    }

    @Override
    public String toString() {
        return "SoldProduct{" + "description=" + this.getDescription() + ", unitPrice=" + this.getUnitPrice()  +
               ", quantity=" + quantity + ", currency=" + currency + '}';
    }
}