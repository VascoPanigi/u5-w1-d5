package vascopanigi.u5_w1_d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vascopanigi.u5_w1_d5.entities.Workspace;
import vascopanigi.u5_w1_d5.enums.WorkspaceType;

import java.util.List;
import java.util.UUID;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, UUID> {
    List<Workspace> findByWorkspaceTypeAndBuilding_City(WorkspaceType workspaceType, String city);

}
