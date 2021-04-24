package Grupo10Metrovias;

public class Ticket {

    private Passenger passenger;
    private int timeWaited;

    public Ticket (Passenger passenger, int actualTime){
        this.passenger = passenger;
        this.timeWaited = actualTime - passenger.getInitialTime();
    }

    public int getTimeWaited() {
        return timeWaited;
    }

    public Passenger getPassenger() {
        return passenger;
    }
}
