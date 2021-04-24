package Grupo10Metrovias;

import utils.IsEmptyException;
import utils.Scanner;
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
        int quantity;
        do {
            quantity = Scanner.getInt(" Ingrese la cantidad de ventanas para la simulacion: ");
        }while(quantity > 25 || quantity < 5);
        subway = new Subway(quantity);
        int opcion;
        do {
            opcion = Scanner.getInt("Menu:\n1. Avanzar 30s de simulacion\n2. Finalizar simulacion");
            if (opcion == 1) advanceSimulation();
        }while(opcion !=2);
        subway.printTickets();
        for (int i = 0; i < subway.getWindows().length; i++) {
            double avgTimeWaited = subway.getWindows()[i].averageTimeWaited();
            int amountCollected = subway.getWindows()[i].getAmountCollected();
            System.out.println("\nLa ventana " + (i+1) + " recolecto: $" + amountCollected + "\n Tiempo promedio de espera: " + avgTimeWaited + " segundos \n");
        }
    }
}
