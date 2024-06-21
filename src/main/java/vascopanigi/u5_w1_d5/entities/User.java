package vascopanigi.u5_w1_d5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    @Column(unique = true)
    private String username;
    private String name;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;

    public User(String email, String name, String username) {
        this.email = email;
        this.name = name;
        this.username = username;
    }
}
