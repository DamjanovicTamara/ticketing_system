package tickets.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "sport_ticket")
@NamedQueries({
        @NamedQuery(name = "tickets.domain.Ticket.findAll",
                query = "select t from Ticket t")})
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id")
    private Player player;

    @Column(name = "ticket_type")
    private TicketType ticketType;

    @Column(name = "quota")
    private Double quota;

    @Column(name = "bet_amount")
    private BigDecimal betAmount;

    @Column(name = "win_amount")
    private BigDecimal winAmount;

    @Column(name = "result")
    private Results result;

    @Column(name = "created_on")
    private LocalDateTime timeCreated;

    @Column(name = "modified_on")
    private LocalDateTime timeModified;

    public Ticket() {
    }

    public Ticket(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Ticket(Long id, Player player, TicketType ticketType, Double quota, BigDecimal betAmount, BigDecimal winAmount, Results result, LocalDateTime timeCreated, LocalDateTime timeModified) {
        this.id = id;
        this.player = player;
        this.ticketType = ticketType;
        this.quota = quota;
        this.betAmount = betAmount;
        this.winAmount = winAmount;
        this.result = result;
        this.timeCreated = timeCreated;
        this.timeModified = timeModified;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty
    public Player getPlayer() {
        return player;
    }

    @JsonProperty
    public void setPlayer(Player player) {
        this.player = player;
    }

    @JsonProperty
    public TicketType getTicketType() {
        return ticketType;
    }

    @JsonProperty
    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    @JsonProperty
    public Double getQuota() {
        return quota;
    }

    @JsonProperty
    public void setQuota(Double quota) {
        this.quota = quota;
    }

    @JsonProperty
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    public BigDecimal getBetAmount() {
        return betAmount;
    }

    @JsonProperty
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    public void setBetAmount(BigDecimal betAmount) {
        this.betAmount = betAmount;
    }

    @JsonProperty
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    public BigDecimal getWinAmount() {
        return winAmount;
    }

    @JsonProperty
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    public void setWinAmount(BigDecimal winAmount) {
        this.winAmount = winAmount;
    }

    @JsonProperty
    public Results getResult() {
        return result;
    }

    @JsonProperty
    public void setResults(Results results) {
        this.result = result;
    }

    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getTimeModified() {
        return timeModified;
    }

    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setTimeModified(LocalDateTime timeModified) {
        this.timeModified = timeModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) && Objects.equals(player, ticket.player) && ticketType == ticket.ticketType && Objects.equals(quota, ticket.quota) && Objects.equals(betAmount, ticket.betAmount) && Objects.equals(winAmount, ticket.winAmount) && result == ticket.result && Objects.equals(timeCreated, ticket.timeCreated) && Objects.equals(timeModified, ticket.timeModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, player, ticketType, quota, betAmount, winAmount, result, timeCreated, timeModified);
    }
}
