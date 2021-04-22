package Grupo10Metrovias;

import StacksAndQueues.DynamicStack;

public class Subway {
    private Window[] windows;
    private StacksAndQueues.DynamicStack<Ticket> tickets;
    private int ticketPrice;
    
    public void saveTicket (Ticket ticket){
        tickets.stack(ticket);
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    static Window[] getWindows() {
        return windows;
    }

    public static DynamicStack<Ticket> getTickets() {
        return tickets;
    }

    public static void setWindowsQuantity(int quantity) {
        windows = new Window[quantity];
    }
}
