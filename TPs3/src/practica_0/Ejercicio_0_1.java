package prog3.practica_0;
import austral.util.Scanner;

public class Ejercicio_0_1 {

    public static void main(String[] args) {
        String input = "";
        while(!input.equals("exit")){
            input = Scanner.getString("\nInput Roman number: ");
            if (validRomanNumber(input)) {
                int n = romanToDecimal(input);
                System.out.println("Integer form of Roman Numeral " + input + " is " + n + "\n");
            } else if (!input.equals("exit")){
                System.out.println("That is a invalid Roman number, try again. " + "\n");
            }
        }
    }

    static int charValue(char c) {
        if (c == 'I')
            return 1;
        if (c == 'V')
            return 5;
        if (c == 'X')
            return 10;
        if (c == 'L')
            return 50;
        if (c == 'C')
            return 100;
        if (c == 'D')
            return 500;
        if (c == 'M')
            return 1000;
        return -1;
    }

    static boolean validRomanNumber(String string){
        for (int i = 0; i < string.length(); i++) {
            int acii = string.charAt(i);
            if (  !(acii == 73 ||
                    acii == 86 ||
                    acii == 88 ||
                    acii == 76 ||
                    acii == 67 ||
                    acii == 68 ||
                    acii == 77))
            {
                return false;
            }
        }
        return true;
    }

    static int romanToDecimal(String romanNumber) {
        int totalSum = 0;                            //suma total
        for (int i = 0; i < romanNumber.length(); i++) {
            int v1 = charValue(romanNumber.charAt(i));         //agarro el valor de la letra de donde estoy parado

            if (i + 1 < romanNumber.length()) {                //si tiene otra letra adelante
                int v2 = charValue(romanNumber.charAt(i + 1)); //agarro el valor de la letra proxima

                if (v1 >= v2) {
                    totalSum += v1;                  //si el valor del proximo caracter es mayor, los sumo a la suma.
                } else {                             //si el valor del proximo caracter es menor,
                    totalSum += v2 - v1;             //le resto la suma total a este valor mayor.
                    i++;                             //sigo contando desde el carecter proximio al mayor.
                }
            } else {
                totalSum += charValue(romanNumber.charAt(i));  //si no tiene un caracter adelante, solo se suma al total.
            }
        }
        return totalSum;
    }
}