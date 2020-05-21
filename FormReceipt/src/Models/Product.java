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
public class Product {
    private String description;
    private float unitPrice;
    
    public Product() {
        
    }
    
    public Product(String description, float unitPrice) {
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" + "unitPrice=" + unitPrice + ", description=" + description + '}';
    }
}