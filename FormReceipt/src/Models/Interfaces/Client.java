/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Interfaces;

import java.util.LinkedHashMap;

/**
 *
 * @author ASUS
 * @param <T>
 * @param <U>
 */
public interface Client<T, U> {
    
    public boolean saveReceipt(T firstObject, U secondObject) throws Exception;
    
    public LinkedHashMap<String, String> getReceipt(String fullName) throws Exception;
}
