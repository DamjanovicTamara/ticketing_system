package tickets.repository;

import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.logback.shaded.guava.base.Optional;
import org.hibernate.SessionFactory;
import tickets.domain.Player;
import java.util.List;

public class PlayerDAO extends AbstractDAO<Player> {

    public PlayerDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    /**
     * Method returns all tickets stored in the database.
     *
     * @return list of all tickets stored in the database
     */
    public List<Player> findAll() {

        return list(namedTypedQuery("tickets.domain.Player.findAll"));
    }


    /**
     * Method looks for an ticket by id.
     *
     * @param id the id of an ticket we are looking for.
     * @return Optional containing the found ticket or an empty Optional
     * otherwise.
     */
    public Optional<Player> findByPlayerId(long id) {
        return Optional.fromNullable(get(id));
    }

    public Player create(Player player) {
        return persist(player);
    }
}
