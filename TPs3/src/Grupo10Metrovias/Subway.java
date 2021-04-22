package Grupo10Metrovias;

import StacksAndQueues.DynamicStack;

import java.util.Random;

public class Subway {
    private Window[] windows;
    private StacksAndQueues.DynamicStack<Ticket> tickets;
    private int windowQty;

    public Subway(int windowQty){
        windows = new Window[windowQty];
        for (int i = 0; i <windowQty; i++) {
            windows[i] = new Window();
        }
        windowQty = windowQty;
    }


    static public void saveTicket (Ticket ticket){
        tickets.stack(ticket);
    }

    public void passengersArrival(){
        for (int i = 0; i < 4; i++) {
            int windowChoice = (int)(new Random().nextInt(windowQty)+1);
            int ticketID = (int)(10000*Math.random());
            windows[windowChoice].enqueueP(new Passenger(ticketID));
        }
    }

    public static Window[] getWindows() {
        return windows;
    }

    public static DynamicStack<Ticket> getTickets() {
        return tickets;
    }

    public static void setWindowsQuantity(int quantity) {
        windows = new Window[quantity];
    }
}
