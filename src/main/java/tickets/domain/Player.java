package tickets.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name ="player")
public class Player {

    @Id
    @GeneratedValue
    private long player_id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="email")
    private String email;

    public Player() {
    }

    public Player(long player_id, String name, String surname, String email) {
        this.player_id = player_id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public long getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(long player_id) {
        this.player_id = player_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return player_id == player.player_id && Objects.equals(name, player.name) && Objects.equals(surname, player.surname) && Objects.equals(email, player.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player_id, name, surname, email);
    }
}
