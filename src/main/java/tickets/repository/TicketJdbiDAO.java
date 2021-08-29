package tickets.repository;


import io.dropwizard.logback.shaded.guava.base.Optional;
import org.hibernate.annotations.SQLInsert;


import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import tickets.domain.Ticket;
import ticketsmapper.TicketMapper;

import java.util.List;
@RegisterMapper(TicketMapper.class)
public interface TicketJdbiDAO {


    /**
     * Method returns all tickets stored in the database.
     *
     * @return list of all tickets stored in the database
     */
    @SqlQuery("SELECT * FROM SPORT_TICKET")
   @RegisterMapper(TicketMapper.class)
    public List<Ticket> findAll();


    /**
     * Method looks for a ticket by id.
     *
     * @param id the id of a ticket we are looking for.
     * @return Optional containing the found ticket or an empty Optional
     * otherwise.
     */
    @SqlQuery("SELECT * FROM SPORT_TICKET WHERE ID =:ID")
    public Optional<Ticket> findByTicketId(Long id);

    @SqlUpdate( "INSERT INTO sport_ticket(ticket_type,quota,bet_amount,result) VALUES (:type, :quota, :betAmount, :result)")
    public  void create(/*@TicketBind */@BindBean Ticket ticket);

    @SqlUpdate("UPDATE SPORT_TICKET SET ticket_type=:type, quota=:quota, bet_amount=:betAmount,result=:result where id=:id")
    public  void update(/*@TicketBind*/@BindBean Ticket ticket);
}
