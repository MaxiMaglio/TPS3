package Grupo10Metrovias;

import StacksAndQueues.DynamicQueue;
import utils.IsEmptyException;

public class Window {
    private StacksAndQueues.DynamicQueue<Passenger> pQueue;
    private int amountCollected;
    private Ticket[] archivedTickets;

    public Ticket generateTicket(Passenger passenger) {
        int idNumber = (int) (Math.random() * 10000);
        int timeWaited = Simulation.getActualTime() - passenger.getInitialTime();
        return new Ticket(passenger, timeWaited, idNumber);
    }

    public void attendPassenger() throws IsEmptyException {
        if (!pQueue.isEmpty()){
            Passenger attendedP = pQueue.dequeue();
            Ticket ticket = generateTicket(attendedP);
            storeTicket(ticket);
            amountCollected += Subway.getTicketPrice();
        }
    }

    private void storeTicket(Ticket ticket){
        Subway.saveTicket(ticket);
        Ticket[] updatedArchivedTickets = new Ticket[archivedTickets.length+1];
        for (int i = 0; i < archivedTickets.length; i++) {
            updatedArchivedTickets[i] = archivedTickets[i];
        }
        updatedArchivedTickets[archivedTickets.length] = ticket;
        archivedTickets = updatedArchivedTickets;
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
