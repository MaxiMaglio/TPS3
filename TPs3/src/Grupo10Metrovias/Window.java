package Grupo10Metrovias;

import StacksAndQueues.DynamicQueue;
import StacksAndQueues.DynamicStack;
import utils.IsEmptyException;

public class Window {
    private StacksAndQueues.DynamicQueue<Passenger> pQueue = new DynamicQueue<>();
    private int amountCollected;
    private DynamicStack<Ticket> archivedTickets = new DynamicStack<>();

    public Passenger attendPassenger() throws IsEmptyException {
        if (!pQueue.isEmpty()){
            Passenger attendedP = pQueue.dequeue();
            amountCollected += 5;
            return attendedP;
        }else{
            return null;
        }
    }

    public void archiveTickets(Ticket ticket){
        archivedTickets.stack(ticket);
    }

    public void enqueueP(Passenger p){
        pQueue.enqueue(p);
    }

    public double averageTimeWaited() throws IsEmptyException {
        int totalWaitedTime = 0;
        int totalTickets = archivedTickets.size();
        while (!archivedTickets.isEmpty()) {
            totalWaitedTime += archivedTickets.peek().getTimeWaited();
            archivedTickets.pop();
        }
        if (totalTickets != 0) {
            return totalWaitedTime / totalTickets;
        }else{
            return 0;
        }
    }

    public int getAmountCollected(){
        return amountCollected;
    }

    public DynamicQueue<Passenger> getPQueue() {
        return pQueue;
    }
}
