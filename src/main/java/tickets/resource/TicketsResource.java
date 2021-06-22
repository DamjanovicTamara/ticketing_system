package tickets.resource;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.logback.shaded.guava.base.Optional;
import org.apache.http.client.HttpClient;
import tickets.repository.PlayerDAO;
import tickets.repository.TicketDAO;
import tickets.domain.Ticket;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@Path("/tickets")
@Produces({MediaType.TEXT_HTML,MediaType.APPLICATION_JSON})
@Consumes(MediaType.APPLICATION_JSON)
public class TicketsResource {

    /**
     * The DAO object to manipulate tickets.
     */
    private TicketDAO ticketDAO;
    private PlayerDAO playerDAO;
    private  HttpClient client;

    Logger logger = Logger.getLogger(TicketsResource.class.getName());

    public TicketsResource(HttpClient client) {
        this.client = client;
    }

    public TicketsResource(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public TicketsResource(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
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
    public Optional<Ticket> findById(@PathParam("id") Long id) {
        return ticketDAO.findByTicketId(id);
    }

    @GET
    @UnitOfWork
    public List<Ticket> listTickets() {
        return ticketDAO.findAll();
    }

    /*@POST
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Ticket createTicket(@PathParam("player") long playerId, @PathParam("ticketType")TicketType type,
                               @PathParam("quota") int quota, @PathParam("betAmount") float betAmount,
                               @PathParam("winAmount") float winAmount,
                               @PathParam("result")Results result) {
        Optional<Player> player = playerDAO.findByPlayerId(playerId);
        Ticket ticket = new Ticket(2,player.get(),type,quota,betAmount,winAmount,result,LocalDateTime.now(),null);
        return ticketDAO.create(ticket);
    }*/
    //POST Method which consumes JSON and returns Ticket objects.
    // While creating a ticket, player is created as well.
    @POST
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Ticket createTicket(Ticket ticket){
        logger.info("New ticket created");
        return ticketDAO.create(ticket);
    }

    /*@POST
    public Response createTicket(Ticket ticket) throws URISyntaxException {
        // validation
      //  Set<ConstraintViolation<Ticket>> violations = validator.validate(ticket);
      //  Ticket t = ticketDAO.findByTicketId(ticket.getId()).get();
      *//*  if (violations.size() > 0) {
            ArrayList<String> validationMessages = new ArrayList<String>();
            for (ConstraintViolation<Employee> violation : violations) {
                validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
            }
            return Response.status(Status.BAD_REQUEST).entity(validationMessages).build();
        }*//*
       *//* if (t != null) {
            EmployeeDB.updateEmployee(employee.getId(), employee);
            return Response.created(new URI("/employees/" + employee.getId()))
                    .build();
        } else
            return Response.status(Status.NOT_FOUND).build();*//*

      Ticket createdTicket= ticketDAO.create(ticket);
      return Response.status(Response.Status.CREATED).entity(createdTicket).build();
    }*/

}
