package tickets.service;


import org.skife.jdbi.v2.sqlobject.CreateSqlObject;
import tickets.domain.Ticket;
import tickets.repository.TicketJdbiDAO;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

public abstract class TicketsService {
    private static final String PART_NOT_FOUND = "Part id %s not found.";
    private static final String DATABASE_REACH_ERROR =
            "Could not reach the MySQL database. The database may be down or there may be network connectivity issues. Details: ";
    private static final String DATABASE_CONNECTION_ERROR =
            "Could not create a connection to the MySQL database. The database configurations are likely incorrect. Details: ";
    private static final String DATABASE_UNEXPECTED_ERROR =
            "Unexpected error occurred while attempting to reach the database. Details: ";
    private static final String SUCCESS = "Success...";
    private static final String UNEXPECTED_ERROR = "An unexpected error occurred while deleting part.";

    @CreateSqlObject
    abstract TicketJdbiDAO ticketDao();

    public List<Ticket> findAllTickets() {
        return ticketDao().findAll();
    }

    public Ticket getTicket(Long id) {
        Ticket ticket = ticketDao().findByTicketId(id).get();
        if (Objects.isNull(ticket)) {
            throw new WebApplicationException(String.format(PART_NOT_FOUND, id), Response.Status.NOT_FOUND);
        }
        return ticket;
    }

    public Ticket createTicket(Ticket ticket) {
        ticketDao().create(ticket);
        return ticketDao().findByTicketId(ticket.getId()).get();
    }

    public Ticket editTicket(Ticket ticket) {
        if (Objects.isNull(ticketDao().findByTicketId(ticket.getId()))) {
            throw new WebApplicationException(String.format(PART_NOT_FOUND, ticket.getId()),
                    Response.Status.NOT_FOUND);
        }
        ticketDao().update(ticket);
        return ticketDao().findByTicketId(ticket.getId()).get();
    }

}
