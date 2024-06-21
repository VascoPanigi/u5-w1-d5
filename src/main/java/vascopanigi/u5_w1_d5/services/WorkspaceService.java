package vascopanigi.u5_w1_d5.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vascopanigi.u5_w1_d5.entities.Workspace;
import vascopanigi.u5_w1_d5.enums.WorkspaceType;
import vascopanigi.u5_w1_d5.repositories.WorkspaceRepository;

import java.util.List;

@Service
public class WorkspaceService {
    @Autowired
    private WorkspaceRepository workspaceRepository;

    public List<Workspace> searchWorkspaces(WorkspaceType workspaceType, String city){
        return workspaceRepository.findByWorkspaceTypeAndBuilding_City(workspaceType, city);
    }




}
