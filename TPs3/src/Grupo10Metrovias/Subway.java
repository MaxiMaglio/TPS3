package Grupo10Metrovias;

import StacksAndQueues.DynamicStack;
import utils.IsEmptyException;

import java.util.Random;

public class Subway {
    private Window[] windows;
    private StacksAndQueues.DynamicStack<Ticket> tickets;
    private int windowQty;

    public Subway(int windowQty){
        this.windows = new Window[windowQty];
        for (int i = 0; i <windowQty; i++) {
            windows[i] = new Window();
        }
        this.tickets = new DynamicStack<>();
        this.windowQty = windowQty;
    }


    public void saveTicket(Ticket ticket){
        tickets.stack(ticket);
    }

    public void passengersArrival(int time){
        for (int i = 0; i < 5; i++) {
            int windowChoice = (new Random().nextInt(windowQty));
            windows[windowChoice].enqueueP(new Passenger(time));
        }
    }

    public void passengerCheckout(int actualTime) throws IsEmptyException {
        for (int i = 0; i < windows.length; i++) {
            if(Math.random()>0.5) {
                if (!windows[i].getPQueue().isEmpty()) {
                    Passenger p = windows[i].attendPassenger();
                    Ticket ticket = generateTicket(p,actualTime);
                    tickets.stack(ticket);
                    windows[i].archiveTickets(ticket);
                }
            }
        }
    }

    public Ticket generateTicket(Passenger p, int actualTime){
        int ticketID = (int)(100000*Math.random());
        return new Ticket(ticketID,p, actualTime);
    }

    public  Window[] getWindows() {
        return windows;
    }

    public  DynamicStack<Ticket> getTickets() {
        return tickets;
    }

    public  void setWindowsQuantity(int quantity) {
        windows = new Window[quantity];
    }

    public void printTickets() throws IsEmptyException {
        int i = 0;
        while(!tickets.isEmpty()){
            System.out.println("Ticket Nro: " + tickets.peek().getTicketID() + "\nTiempo de espera: " + tickets.peek().getTimeWaited() + " segundos\n");
            tickets.pop();
        }
    }

}
