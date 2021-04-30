package Grupo10Metrovias;

import StacksAndQueues.DynamicStack;
import utils.IsEmptyException;
import utils.UI;

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

    public Ticket generateTicket(Passenger p, int actualTime) {
        double number = (Math.random());
        int ticketID;
        if (number < 0.1) {
            ticketID = (int) ((number+ 0.1) * 100000);
        } else {
            ticketID = (int) (number * 100000);
        }
        return new Ticket(ticketID, p, actualTime);
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

    public void printTicketsInfo() throws IsEmptyException {
        UI.message("Informacion de tickets registrados");
        System.out.println(" (Nro de ticket) -> [Tiempo de espera]\n");
        while(!tickets.isEmpty()){
                if (!tickets.isEmpty()) {
                    System.out.println("\t\t (" + tickets.peek().getTicketID() + ") -> [" + tickets.peek().getTimeWaited() + "s]");;
                    tickets.pop();
                }
        }
    }

    public void printWindowsInfo() throws IsEmptyException {
        UI.message("Informacion de las ventanillas");
        System.out.println(" [Nro de ventanilla] -> $ monto recaudado ~ (Tiempo promedio de espera)\n");
        for (int i = 0; i < windows.length; i++) {
            System.out.println("\t\t [" + (i+1) + "] -> $" + windows[i].getAmountCollected() + " ~ (" + windows[i].averageTimeWaited() + "s)");
        }
    }

}
