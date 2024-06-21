package vascopanigi.u5_w1_d5.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vascopanigi.u5_w1_d5.enums.WorkspaceType;
import vascopanigi.u5_w1_d5.services.WorkspaceService;

@Component
public class ReservationRunner implements CommandLineRunner {


    @Autowired
    private WorkspaceService workspaceService;

    @Override
    public void run(String... args) throws Exception{
        System.out.println("-----------------------FILTERY BY WORKSPACETYPE AND BUILDING CITY-------------------------");
        workspaceService.searchWorkspaces(WorkspaceType.OPENSPACE, "Marino umbro").forEach(System.out::println);



    }

}
