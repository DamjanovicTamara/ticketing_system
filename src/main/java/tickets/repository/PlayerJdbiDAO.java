package tickets.repository;

import io.dropwizard.logback.shaded.guava.base.Optional;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import tickets.domain.Player;
import ticketsmapper.PlayerMapper;

@RegisterMapper(PlayerMapper.class)
public interface PlayerJdbiDAO {
    @SqlQuery("SELECT * FROM player WHERE player_id =:ID")
    public Optional<Player> findByPlayerId(Long id);
}
