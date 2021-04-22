package Grupo10Metrovias;

import StacksAndQueues.DynamicQueue;
import utils.IsEmptyException;

public class Window {
    private StacksAndQueues.DynamicQueue<Passenger> pQueue = new DynamicQueue<>();
    private int amountCollected;
    private Ticket[] archivedTickets;

    public void attendPassenger() throws IsEmptyException {
        if (!pQueue.isEmpty()){
            Passenger attendedP = pQueue.dequeue();
            Ticket ticket = generateTicket(attendedP);
            storeTicket(ticket);
            amountCollected += Subway.getTicketPrice();
        }
    }

    public void enqueueP(Passenger p){
        pQueue.enqueue(p);
        amountCollected+= 5;
    }

    public double getAverageTimeWaited(){
        int totalWaitedTime = 0;
        for (int i = 0; i < archivedTickets.length; i++) {
            totalWaitedTime += archivedTickets[i].getTimeWaited();
        }
        if (totalWaitedTime == 0) return 0;
        else return totalWaitedTime / archivedTickets.length;
    }

    public DynamicQueue<Passenger> getpQueue() {
        return pQueue;
    }
}
