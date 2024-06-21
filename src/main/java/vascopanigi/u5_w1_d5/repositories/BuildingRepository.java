package vascopanigi.u5_w1_d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vascopanigi.u5_w1_d5.entities.Building;

import java.util.UUID;

public interface BuildingRepository extends JpaRepository<Building, UUID> {
}
