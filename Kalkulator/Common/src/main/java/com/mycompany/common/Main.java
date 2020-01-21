package com.mycompany.common;

import com.mycompany.implementacja.Implementacja;
import java.util.Scanner;


public class Main {
    String a;
    public static String operacja(String a, int i) {
        int nawiasy = 0;
        for (int j = i + 1; j < a.length(); j++) {
            System.out.println("J=" + String.valueOf(j));
            if (a.charAt(j) == '(') {
                nawiasy++;
            }
            if (a.charAt(j) == ')') {
                nawiasy--;
            }
            if (nawiasy == 0) {
                a = a.substring(0, i) + a.substring(i, j + 1) + "^0.5" + a.substring(j + 1);
                return a;
            }
        }
        return "";
    }

    
    public static void main(String[] args) {

        String operation="2^3";
        Implementacja calc = new Implementacja();
        calc.oblicz(operation);
    
    }
    
}
