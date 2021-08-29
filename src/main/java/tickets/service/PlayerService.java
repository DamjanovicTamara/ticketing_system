package tickets.service;

import org.skife.jdbi.v2.sqlobject.CreateSqlObject;
import tickets.domain.Player;
import tickets.repository.PlayerJdbiDAO;


public abstract class PlayerService {

    @CreateSqlObject
    abstract PlayerJdbiDAO playerJdbiDAO();

        public Player getPlayer(Long id) {
        Player player = playerJdbiDAO().findByPlayerId(id).get();

        return player;
    }
}
