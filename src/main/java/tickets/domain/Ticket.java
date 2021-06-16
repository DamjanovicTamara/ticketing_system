package tickets.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "sport_ticket")
@NamedQueries({
        @NamedQuery( name = "tickets.domain.Ticket.findAll",
                     query= "select t from Ticket t")})
public class Ticket {

    @Id
    @GeneratedValue
    private long ticketId;

    @ManyToOne
    @JoinColumn(name="player_id")
    private Player player;

    @Column(name="ticket_type")
    private TicketType ticketType;

    @Column(name="quota")
    private float quota;

    @Column(name="bet_amount")
    private float betAmount;

    @Column(name="winAMount")
    private float winAmount;

    @Column(name="results")
    private Results results;

    @Column(name="created_on")
    private LocalDateTime timeCreated;

    @Column(name="modified_on")
    private LocalDateTime timeModified;

    public Ticket() {
    }

    public Ticket(long ticketId, Player player, TicketType ticketType, float quota, float betAmount, float winAmount, Results results, LocalDateTime timeCreated, LocalDateTime timeModified) {
        this.ticketId = ticketId;
        this.player = player;
        this.ticketType = ticketType;
        this.quota = quota;
        this.betAmount = betAmount;
        this.winAmount = winAmount;
        this.results = results;
        this.timeCreated = timeCreated;
        this.timeModified = timeModified;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public float getQuota() {
        return quota;
    }

    public void setQuota(float quota) {
        this.quota = quota;
    }

    public float getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(float betAmount) {
        this.betAmount = betAmount;
    }

    public float getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(float winAmount) {
        this.winAmount = winAmount;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public LocalDateTime getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(LocalDateTime timeModified) {
        this.timeModified = timeModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return ticketId == ticket.ticketId && Float.compare(ticket.quota, quota) == 0 && Float.compare(ticket.betAmount, betAmount) == 0 && Float.compare(ticket.winAmount, winAmount) == 0 && Objects.equals(player, ticket.player) && ticketType == ticket.ticketType && results == ticket.results && Objects.equals(timeCreated, ticket.timeCreated) && Objects.equals(timeModified, ticket.timeModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, player, ticketType, quota, betAmount, winAmount, results, timeCreated, timeModified);
    }
}
