package tickets.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "player")
@NamedQueries({
        @NamedQuery(name = "tickets.domain.Player.findAll",
                query = "select t from Player t")})
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long playerId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    public Player() {
    }

    public Player(Long playerId, String name, String surname, String email) {
        this.playerId = playerId;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public String getSurname() {
        return surname;
    }

    @JsonProperty
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @JsonProperty
    public String getEmail() {
        return email;
    }

    @JsonProperty
    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerId, player.playerId) && Objects.equals(name, player.name) && Objects.equals(surname, player.surname) && Objects.equals(email, player.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, name, surname, email);
    }
}
