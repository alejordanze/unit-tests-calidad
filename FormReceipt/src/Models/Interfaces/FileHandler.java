/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Interfaces;

import java.io.IOException;
import java.util.LinkedHashMap;

/**
 *
 * @author ASUS
 */
public interface FileHandler<T> {
    
    public boolean addToMap(T object)throws Exception;
    
    public boolean createFile(String filename)throws IOException;
    
    public LinkedHashMap<String, String> getFile(String filename)throws Exception;
}
