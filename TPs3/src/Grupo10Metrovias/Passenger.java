package Grupo10Metrovias;

public class Passenger {
    private int initialTime;
    private int TicketID;

    public Passenger(int ticketNumber, int initialTime) {
        this.TicketID = ticketNumber;
        this.initialTime = initialTime;
    }



    public int getInitialTime() {
        return initialTime;
    }
}
