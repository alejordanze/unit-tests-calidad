/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Models.Interfaces.ObjectHandler;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/**
 *
 * @author ASUS
 */
public class JsonObject implements ObjectHandler {
    private final JSONObject jsonObject;
    
    public JsonObject() {
        this.jsonObject = new JSONObject();
    }
    
    @Override
    public void addPairToJson(String key, String value) {
        jsonObject.put(key, value);
    }
    
    @Override
    public boolean saveJsonFile(String name) throws IOException {
        String nameExtension = name + ".json";
        String pathFile = "FormReceipt/src/jsonFile/" + nameExtension;
        FileWriter file = new FileWriter(pathFile);
        file.write(jsonObject.toString());
        file.close();
        
        return true;
    }
    
    @Override
    public JSONObject getJsonFile(String filename) throws FileNotFoundException, Exception {
        String completeName = filename + ".json";
        String pathFile = "FormReceipt/src/jsonFile/" + completeName;
        FileReader reader = new FileReader(pathFile);
        JSONParser jsonParser = new JSONParser();
        
        return (JSONObject) jsonParser.parse(reader);
    }

    @Override
    public int size() {
        return this.jsonObject.size();
    }
}
