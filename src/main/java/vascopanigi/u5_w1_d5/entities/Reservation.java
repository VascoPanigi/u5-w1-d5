package vascopanigi.u5_w1_d5.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="reservations")
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private LocalDate reservationDate;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="workspace_id")
    private Workspace workspace;

    public Reservation(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }
}
