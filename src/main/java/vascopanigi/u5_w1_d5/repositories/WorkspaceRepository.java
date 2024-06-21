package vascopanigi.u5_w1_d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vascopanigi.u5_w1_d5.entities.Workspace;

import java.util.UUID;

public interface WorkspaceRepository extends JpaRepository<Workspace, UUID> {
}
