package ticketsmapper;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import tickets.domain.Player;
import tickets.domain.Results;
import tickets.domain.Ticket;
import tickets.domain.TicketType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerMapper implements ResultSetMapper<Player> {
    @Override
    public Player map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        Player player = new Player();
        player.setPlayerId(resultSet.getLong("player_id"));
        player.setName(resultSet.getString("name"));
        player.setSurname(resultSet.getString("surname"));
        player.setEmail(resultSet.getString("surname"));

        return player;
    }
}
