package Grupo10Metrovias;

public class Passenger {
    private int initialTime;
    private int ticketID;

    public Passenger(int ticketID, int initialTime) {
        this.ticketID = ticketID;
        this.initialTime = initialTime;
    }



    public int getInitialTime() {
        return initialTime;
    }

    public int getTicketID() {
        return ticketID;
    }
}
