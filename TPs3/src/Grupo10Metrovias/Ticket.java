package Grupo10Metrovias;

public class Ticket {
    private int idNumber;
    private Passenger passenger;
    private int timeWaited;
    public Ticket (Passenger passenger, int timeWaited, int idNumber){
        this.passenger = passenger;
        this.timeWaited = timeWaited;
        this.idNumber = idNumber;
    }

    public int getTimeWaited() {
        return timeWaited;
    }
}
