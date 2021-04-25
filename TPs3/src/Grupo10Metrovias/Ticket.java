package Grupo10Metrovias;

public class Ticket {

    private Passenger passenger;
    private int timeWaited;
    private int ticketID;

    public Ticket (int ticketID, Passenger passenger, int actualTime){
        this.ticketID = ticketID;
        this.passenger = passenger;
        this.timeWaited = actualTime - passenger.getInitialTime();
    }

    public int getTimeWaited() {
        return timeWaited;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public int getTicketID() {
        return ticketID;
    }
}
