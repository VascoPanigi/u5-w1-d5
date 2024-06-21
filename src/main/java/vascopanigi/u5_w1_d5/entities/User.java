package vascopanigi.u5_w1_d5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
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
}
