package tickets.repository;

import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.logback.shaded.guava.base.Optional;
import org.hibernate.SessionFactory;
import tickets.domain.Ticket;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class TicketDAO extends AbstractDAO<Ticket> {

    public TicketDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    /**
     * Method returns all tickets stored in the database.
     *
     * @return list of all tickets stored in the database
     */
    public List<Ticket> findAll() {

            return list(namedTypedQuery("tickets.domain.Ticket.findAll"));
        }


    /**
     * Method looks for an ticket by id.
     *
     * @param id the id of an ticket we are looking for.
     * @return Optional containing the found ticket or an empty Optional
     * otherwise.
     */
    public Optional<Ticket> findByTicketId(long id) {
        return Optional.fromNullable(get(id));
    }

    public Ticket create(Ticket ticket) {
        return persist(ticket);
    }

}
