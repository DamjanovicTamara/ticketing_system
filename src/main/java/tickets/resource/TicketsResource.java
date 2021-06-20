package tickets.resource;

import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import io.dropwizard.logback.shaded.guava.base.Optional;
import org.apache.http.client.HttpClient;
import tickets.repository.TicketDAO;
import tickets.domain.Ticket;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tickets")
@Produces({MediaType.TEXT_HTML,MediaType.APPLICATION_JSON})
public class TicketsResource {

    /**
     * The DAO object to manipulate tickets.
     */
    private TicketDAO ticketDAO;
    private  HttpClient client;

    public TicketsResource(HttpClient client) {
        this.client = client;
    }

    public TicketsResource(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }


    /**
     * Method looks for an tickets by id.
     *
     * @param id the id of an tickets we are looking for.
     * @return Optional containing the found ticket or an empty Optional
     * otherwise.
     */
    @GET
    @Path("/{id}")
    @UnitOfWork
    public Optional<Ticket> findById(@PathParam("id") LongParam id) {
        return ticketDAO.findByTicketId(id.get());
    }

    @GET
    @UnitOfWork
    public List<Ticket> listTickets() {
        return ticketDAO.findAll();
    }

    @POST
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create/{ticket}")
    public Ticket createTicket(@Valid Ticket ticket) {
        return ticketDAO.create(ticket);
    }
}
