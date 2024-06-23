package vascopanigi.u5_w1_d5.runners;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import vascopanigi.u5_w1_d5.entities.Building;
import vascopanigi.u5_w1_d5.entities.Workspace;
import vascopanigi.u5_w1_d5.enums.WorkspaceType;
import vascopanigi.u5_w1_d5.repositories.BuildingRepository;
import vascopanigi.u5_w1_d5.repositories.WorkspaceRepository;

import java.util.Locale;

@Component
@Order(1)
public class DatabaseRunner implements CommandLineRunner {
    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @Override
    public void run(String... args) throws Exception {
        // At the start of this application, i need buildings and workspaces
        // Just like we needed pizzas, drinks, tables and toppings the other day
        // Our variables now are the Users and their reservations
        Faker faker = new Faker(Locale.ITALY);


        //-----------------------------------------REFACTORED DB RUNNER -----------------------------------------------
        for (int i = 0; i < 5; i++) {
        Building building = new Building(faker.address().city(), faker.address().streetAddress(), faker.gameOfThrones().dragon());
            buildingRepository.save(building);
            for (int j = 1; j < 4; j++) {
                WorkspaceType type = switch (j) {
                    case 1 -> WorkspaceType.OPENSPACE;
                    case 2 -> WorkspaceType.PRIVATE;
                    case 3 -> WorkspaceType.MEETING_ROOM;
                    default -> null;
                };
                Workspace workspace1 = new Workspace("Open space workspace", type, 30);
                workspace1.setBuilding(building);
                workspaceRepository.save(workspace1);
            }

        }



        //---------------------------------------OLD METHOD DO NOT USE----------------------------------------------------------
        //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


//        Building building1 = new Building(faker.address().city(), faker.address().streetAddress(), faker.gameOfThrones().dragon());
//        Building building2 = new Building(faker.address().city(), faker.address().streetAddress(), faker.gameOfThrones().dragon());
//        Building building3 = new Building(faker.address().city(), faker.address().streetAddress(), faker.gameOfThrones().dragon());
//        Building building4 = new Building(faker.address().city(), faker.address().streetAddress(), faker.gameOfThrones().dragon());
//
//        buildingRepository.saveAll(Arrays.asList(building1, building2, building3, building4));
//
//
//        Workspace workspace1 = new Workspace("Open space workspace", WorkspaceType.OPENSPACE, 30);
//        Workspace workspace2 = new Workspace("Private workspace", WorkspaceType.PRIVATE, 20);
//        Workspace workspace3 = new Workspace("Cozy meeting room", WorkspaceType.MEETING_ROOM, 40);
//        Workspace workspace4 = new Workspace("Open space workspace", WorkspaceType.OPENSPACE, 30);
//
//
//        workspace1.setBuilding(building1);
//        workspace2.setBuilding(building2);
//        workspace3.setBuilding(building3);
//        workspace4.setBuilding(building3);
//
//        workspaceRepository.saveAll(Arrays.asList(workspace1, workspace2, workspace3, workspace4));
    }
}
