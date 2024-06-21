package vascopanigi.u5_w1_d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vascopanigi.u5_w1_d5.entities.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
