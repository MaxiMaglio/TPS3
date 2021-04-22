package Grupo10Metrovias;

public class Passenger {
    private int initialTime;
    private int TicketID;

    public Passenger(int ticketNumber) {
        this.TicketID = ticketNumber;
    }

    public int getInitialTime() {
        return initialTime;
    }
}
