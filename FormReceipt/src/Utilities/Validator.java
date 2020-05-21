/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 *
 * @author ASUS
 */
public class Validator {
    
    private static final int MIN_VALUE = 10;
    private static final int MAX_VALUE = 100;
    
    private static String verifyIsOnlyNumbers(String value) {
        String regularExpression = "[0-9]+";
        
        return value.matches(regularExpression) ? "" : "The field must have only integer numbers";
    }
    
    private static String verifyIsDecimalNumbers(String value) {
        String regularExpression = "[0-9]+(\\.[0-9]{1,2})?";
        
        return value.matches(regularExpression) ? "" : "The field must have only integer or decimal numbers";
    }
    
    private static String verifyIsOnlyLetters(String value) {
        String regularExpression = "[a-zA-Z ]+";
        
        return value.matches(regularExpression) ? "" : "The field must have only letters";
    }
    
    private static String verifyLength(String value) {
        boolean isValidLength = value.length() >= MIN_VALUE && value.length() <= MAX_VALUE;
        
        return isValidLength ? "" : "The field should be between " + MIN_VALUE + " and " + MAX_VALUE + " characters";
    }
    
    private static String verifyLength(String value, int maxValue) {
        boolean isValidLength = value.length() >= MIN_VALUE && value.length() <= maxValue;
        
        return isValidLength ? "" : "The field should be between " + MIN_VALUE + " and " + maxValue + " characters";
    }
    
    private static String verifyLength(String value, int minValue, int maxValue) {
        boolean isValidLength = value.length() >= minValue && value.length() <= maxValue;
        
        return isValidLength ? "" : "The field should be between " + minValue + " and " + maxValue + " characters";
    }
    
    public static String verifyEmail(String value) {
        String regularExpresion = "[A-Za-z0-9._+-]+@[A-Za-z]+\\.[A-Za-z]{2,3}";
        
        return value.matches(regularExpresion) ? "" : "The email is incorrect, e.g. example@gmail.com";
    }
    
    public static String verifyCreditCard(String value) {
        String regularExpresion = "[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}";
        
        return value.matches(regularExpresion) ? "" : "The credit card is incorrect e.g. xxxx-xxxx-xxxx-xxxx";
    }
    
    public static String validateFullName(String value) {
        String response = verifyLength(value);
        if (!response.isEmpty()) {
            return response;
        }
        
        response = verifyIsOnlyLetters(value);
        
        return response;
    }
    
    public static String validateCiNumber(String value) {
        String response = verifyLength(value, 6, 10);
        if (!response.isEmpty()) {
            return response;
        }
        
        response = verifyIsOnlyNumbers(value);
        
        return response;
    }
    
    
    
    public static String applyValidation(String value, String validation) {
        String messageResponse = "";
        
        switch(validation) {
            case "validateFullName":
                messageResponse = validateFullName(value);
                break;
            case "validateCiNumber":
                messageResponse = validateCiNumber(value);
                break;
            case "validateEmail":
                messageResponse = verifyEmail(value);
                break;
            case "validateAddress":
                messageResponse = verifyLength(value, 100);
                break;
            case "verifyCreditCard":
                messageResponse = verifyCreditCard(value);
                break;
            case "validateDescription":
                messageResponse = verifyLength(value, 100);
                break;
            case "validateUnitPrice":
                messageResponse = verifyIsDecimalNumbers(value);
                break;
            case "validateQuantity":
                messageResponse = verifyIsOnlyNumbers(value);
                break;
            default:
        
                break;
        }
        
        return messageResponse;
    }
}