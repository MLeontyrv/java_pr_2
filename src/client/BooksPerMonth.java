package client;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

public class TicketsPerMonth implements Serializable {
    private final Map<LocalDate, Integer> ticketsByDate;
    public TicketsPerMonth(Map<LocalDate,Integer> ticketsByDate) {
        this.ticketsByDate = ticketsByDate;
    }
    public Map<LocalDate, Integer> getTicketsByDate() {
        return ticketsByDate;
    }
}