package tickets.views;

import tickets.domain.Ticket;

import io.dropwizard.views.View;

import java.util.List;


public class TicketView extends View {

    private final Ticket ticket;
    private List<Ticket> tickets;

    public TicketView(Ticket ticket, List<Ticket> tickets) {
        super("ticket.mustache");
        this.ticket = ticket;
        this.tickets=tickets;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public List<Ticket> getTickets(){
        return tickets;
    }
}
