package vascopanigi.u5_w1_d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vascopanigi.u5_w1_d5.entities.Building;

import java.util.List;
import java.util.UUID;
@Repository
public interface BuildingRepository extends JpaRepository<Building, UUID> {
    @Query("SELECT DISTINCT b.city FROM Building b")
    List<String> findAllDistinctCities();
}
