package tickets.resource;
import io.dropwizard.hibernate.UnitOfWork;
import tickets.domain.Ticket;
import tickets.repository.TicketJdbiDAO;
import tickets.service.PlayerService;
import tickets.service.TicketsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/tickets")
@Produces({MediaType.TEXT_HTML,MediaType.APPLICATION_JSON})
@Consumes(MediaType.APPLICATION_JSON)
public class TicketsResource {

    Logger logger = Logger.getLogger(TicketsResource.class.getName());

    private  TicketsService ticketsService;

    private PlayerService playerService;

    public TicketsResource(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }

    public TicketsResource(PlayerService playerService) {
        this.playerService = playerService;
    }


    /**
     * Method looks for a tickets by id.
     *
     * @param id the id of a tickets we are looking for.
     * @return Optional containing the found ticket or an empty Optional
     * otherwise.
     */
    @GET
    @Path("/{id}")
    @UnitOfWork
    public Ticket findById(@PathParam("id") Long id) {
        return ticketsService.getTicket(id);
    }

    @GET
    @UnitOfWork
    public List<Ticket> listTickets() {
        return ticketsService.findAllTickets();
    }


    // While creating a ticket, player is created as well.
    @POST
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createTicket(Ticket ticket){
        logger.info("New ticket created");
         ticketsService.createTicket(ticket);
        return Response.status(Response.Status.CREATED).entity(ticket).build();
    }


}
