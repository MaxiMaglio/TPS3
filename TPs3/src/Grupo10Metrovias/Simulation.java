package Grupo10Metrovias;

import utils.IsEmptyException;
import utils.Scanner;
import java.util.Random;

public class Simulation {
    static private int actualTime = 0;
    static public Subway subway;


    public void advanceSimulation () throws IsEmptyException {
        actualTime+=30;
        for (int i = 0; i < 5; i++) {
            Subway.getWindows()[new Random().nextInt(Subway.getWindows().length)].getpQueue().enqueue(new Passenger(actualTime));
        }
        for (int i = 0; i < Subway.getWindows().length; i++) {
            if (Math.random() > 0.5){
                Subway.getWindows()[i].attendPassenger();
            }
        }
    }

    public void runSimulation() throws IsEmptyException {
        int quantity;
        do {
            quantity = Scanner.getInt(" Ingrese la cantidad de ventanas para la simulacion: ");
        }while(quantity > 25 || quantity < 5);
        Subway.setWindowsQuantity(quantity);
        int opcion;
        do {
            opcion = Scanner.getInt("Menu:\n1. Avanzar 30s de simulacion\n2. Finalizar simulacion");
            if (opcion == 1) advanceSimulation();
        }while(opcion !=2);
        Subway.getTickets().printStack();
    }


    static public int getActualTime() {
        return actualTime;
    }


}
