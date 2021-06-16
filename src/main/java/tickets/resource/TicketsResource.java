package tickets.resource;

import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import io.dropwizard.logback.shaded.guava.base.Optional;
import tickets.repository.TicketDAO;
import tickets.domain.Ticket;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/tickets")
@Produces(MediaType.APPLICATION_JSON)
public class TicketsResource {

    /**
     * The DAO object to manipulate tickets.
     */
    private TicketDAO ticketDAO;

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
        return ticketDAO.findById(id.get());
    }
}
