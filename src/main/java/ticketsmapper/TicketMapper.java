package ticketsmapper;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import tickets.domain.Player;
import tickets.domain.Results;
import tickets.domain.Ticket;
import tickets.domain.TicketType;
import tickets.repository.PlayerJdbiDAO;
import tickets.service.PlayerService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class TicketMapper  implements ResultSetMapper<Ticket> {

    private PlayerService playerService;


    @Override
    public Ticket map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setId(resultSet.getLong("id"));
        ticket.setTicketType(Arrays.stream(TicketType.values()).findAny().get());
        ticket.setQuota(resultSet.getDouble("quota"));
        ticket.setBetAmount(resultSet.getBigDecimal("bet_amount"));
        ticket.setWinAmount(resultSet.getBigDecimal("win_amount"));
        ticket.setPlayer(playerService.getPlayer(resultSet.getLong("player_id")));
        ticket.setResults(Arrays.stream(Results.values()).findAny().get());
        return ticket;
    }
}
