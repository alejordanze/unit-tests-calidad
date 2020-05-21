/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.JSONObject;

/**
 *
 * @author ASUS
 */
public interface ObjectHandler {
    
    public void addPairToJson(String key, String value);
    
    public boolean saveJsonFile(String name) throws IOException;
    
    public int size();
    
    public JSONObject getJsonFile(String filename) throws FileNotFoundException, Exception;
}
