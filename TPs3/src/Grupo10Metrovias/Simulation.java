package Grupo10Metrovias;

import StacksAndQueues.DynamicStack;
import utils.IsEmptyException;
import utils.Scanner;
import utils.UI;

import java.util.Random;

public class Simulation {
    static private int actualTime = 0;
    static public Subway subway;



    public void advanceSimulation () throws IsEmptyException {
        subway.passengersArrival(actualTime);
        actualTime+=30;
        subway.passengerCheckout(actualTime);
    }

    public void runSimulation() throws IsEmptyException {
        UI.clear();
        int quantity;
        do {
            UI.title("Grupo 10 ~ Metrovias");
            quantity = Scanner.getInt("\n\n\n Ingrese la cantidad de ventanillas que desea simular: ");
            UI.clear();
            if(quantity > 25 || quantity < 5){
                UI.message("La cantidad de ventanas debe ser entre 5 y 25");
            }
        }while(quantity > 25 || quantity < 5);
        subway = new Subway(quantity);
        int opcion;
        do {
            UI.clear();
            UI.title("MENU");
            System.out.println("Tiempo de simulacion transcurrido: " + actualTime + "s. ⏱");
            opcion = Scanner.getInt("\n1. Avanzar 30s de simulacion\n2. Finalizar simulacion\n\nIntroduzca su opcion: ");
            if (opcion == 1) advanceSimulation();
        }while(opcion !=2);
        UI.clear();
        UI.title("Informacion de la simulacion");
        System.out.println();
        subway.printWindowsInfo();
        System.out.println();
        subway.printTicketsInfo();
    }
}

