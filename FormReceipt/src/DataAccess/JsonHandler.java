/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Models.Interfaces.FileHandler;
import Models.Interfaces.ObjectHandler;
import Utilities.JsonObject;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import org.json.simple.JSONObject;

/**
 *
 * @author ASUS
 * @param <T>
 */
public class JsonHandler<T> implements FileHandler<T> {
    
    private ObjectHandler jsonObject;
    
    public JsonHandler() {
        this.jsonObject = new JsonObject();
    }
    
    public JsonHandler(ObjectHandler jsonObject) {
        this.jsonObject = jsonObject;
    }
    
    @Override
    public boolean addToMap(T object) throws Exception {
        Class<?> classObject = object.getClass();
        Field[] fieldsSuperClass = classObject.getSuperclass().getDeclaredFields();
        Field[] fieldsClass = classObject.getDeclaredFields();
        
        ArrayList<Field> fields = new ArrayList<>();
        fields.addAll(Arrays.asList(fieldsSuperClass));
        fields.addAll(Arrays.asList(fieldsClass));
        
        for( Field field : fields ){
            String fieldName = field.getName();
            String fieldNameUpperCase = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            String methodName = "get" + fieldNameUpperCase;
            Method instanceMethod = classObject.getMethod(methodName);
            String valueProperty = instanceMethod.invoke(object).toString();
            
            this.jsonObject.addPairToJson(fieldNameUpperCase, valueProperty);
       }
        
        return true;
    }
    
    @Override
    public boolean createFile(String fileName) throws IOException {
        this.jsonObject.saveJsonFile(fileName);
        
        return true;
    }
    
    @Override
    public LinkedHashMap<String, String> getFile(String fileName) throws Exception {
        LinkedHashMap<String, String> mapValues = new LinkedHashMap<>();
        
        JSONObject jsonObjectFile = this.jsonObject.getJsonFile(fileName);
        Iterator iterator = jsonObjectFile.entrySet().iterator();
        
        while (iterator.hasNext()) {
            Entry<String, String> entry = (Entry<String, String>) iterator.next();
            mapValues.put(entry.getKey(), entry.getValue());
        }
        
        return mapValues;
    }
}