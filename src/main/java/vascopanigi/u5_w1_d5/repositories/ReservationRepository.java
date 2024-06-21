package vascopanigi.u5_w1_d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vascopanigi.u5_w1_d5.entities.Reservation;

import java.util.UUID;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation , UUID> {
}
