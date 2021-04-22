package Grupo10Metrovias;

import StacksAndQueues.DynamicStack;

public class Subway {
    static private Window[] windows;
    static private StacksAndQueues.DynamicStack<Ticket> tickets;
    static private int ticketPrice;
    
    static public void saveTicket (Ticket ticket){
        tickets.stack(ticket);
    }

    static public int getTicketPrice() {
        return ticketPrice;
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
