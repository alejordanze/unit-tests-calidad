/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Utilities.Validator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class MenuGenerator {
    
    private static final int LENGTH_ROW = 30;
    private static Scanner scanner = new Scanner(System.in);
   
    public static void generateMenu(String title, ArrayList<String> options) {
        
        generateHeader(title);

        for (int i = 0; i < options.size(); i++) {
            System.out.println("\t" + (i + 1) + ".- " + options.get(i));
        }
        
        generateFooter();
    }
    
    public static void generateMenu(String title, LinkedHashMap<String, String> options) {
        
        generateHeader(title);
        
        options.forEach((key, value) -> {
            System.out.println("\t" + value);
        });
        
        generateFooter();
    }
    
    public static void generateInformationSection(String title, LinkedHashMap<String, String> rows) {
        System.out.println(title);
        
        rows.forEach((key, value) -> {
            System.out.println("\t" + formatValue(key) + value);
        });
    }
    
    public static void generateInformationSection(LinkedHashMap<String, String> rows) {
        rows.forEach((key, value) -> {
            System.out.println(formatValue(key) + value);
        });
    }
    
    public static int getOption() {
        int selection = 0;
        Scanner sc = new Scanner(System.in);

        if(sc.hasNext()) {
        	selection = sc.nextInt();
        }
        
        System.out.println("option entered: "+ selection);
        return selection;
    }
    
    public static String menuValidation(String message, String validation) {
        String response = "";
        String errorMessage = "error";
        
        while (!errorMessage.isEmpty()) {
            System.out.print(message);
            String valueEntered = scanner.nextLine();
            System.out.println("value entered: "+ valueEntered);
            errorMessage = Validator.applyValidation(valueEntered, validation);
            if (errorMessage.isEmpty()) {
                response = valueEntered;
            } else {
                System.out.println("<<<<<< " + errorMessage + " >>>>>>");
            }
        }
        
        return response;
    }
    
    private static void generateHeader(String title) {
        System.out.println(title);
        System.out.println("---------------------------");
    }
    
    private static void generateFooter() {
        System.out.print("Choose a options => ");
    }
    
    private static String formatValue(String value) {
        StringBuilder valueBuilder = new StringBuilder(LENGTH_ROW);
        valueBuilder.append(value);
        int restSpaces = LENGTH_ROW - valueBuilder.length();
        
        for (int i = 1; i < restSpaces; i++){
           valueBuilder.append(" ");
        }
        
        return valueBuilder.toString();
    }
}
