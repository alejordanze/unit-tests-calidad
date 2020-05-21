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
public class Buyer extends User {
    
    private String paymentMethod;
    private String creditCardNumber;
    
    public Buyer() {
        super();
    }
    
    public Buyer(String fullName, String ci, String email, String address, String paymentMethod, String creditCardNumber) {
        super(fullName, ci, email, address);
        this.paymentMethod = paymentMethod;
        this.creditCardNumber = creditCardNumber;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public String toString() {
        return "Buyer{" + "fullName=" + this.getFullName() + ", ci=" + this.getCi() + 
               ", email=" + this.getEmail() + ", address=" + this.getAddress() + " paymentMethod=" + 
               paymentMethod + ", creditCardNumber=" + creditCardNumber + '}';
    }
}
