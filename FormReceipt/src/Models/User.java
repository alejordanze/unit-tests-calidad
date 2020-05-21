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
public class User {
    private String fullName;
    private String ci;
    private String email;
    private String address;
    
    public User() {
    }
    
    public User(String fullName, String ci, String email, String address) {
        this.fullName = fullName;
        this.ci = ci;
        this.email = email;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" + "fullName=" + fullName + ", ci=" + ci + ", email=" + email + ", address=" + address + '}';
    }
}
