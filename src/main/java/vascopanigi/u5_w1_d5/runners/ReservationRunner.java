package vascopanigi.u5_w1_d5.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vascopanigi.u5_w1_d5.entities.Reservation;
import vascopanigi.u5_w1_d5.entities.User;
import vascopanigi.u5_w1_d5.entities.Workspace;
import vascopanigi.u5_w1_d5.enums.WorkspaceType;
import vascopanigi.u5_w1_d5.repositories.ReservationRepository;
import vascopanigi.u5_w1_d5.services.ReservationService;
import vascopanigi.u5_w1_d5.services.UserService;
import vascopanigi.u5_w1_d5.services.WorkspaceService;

import java.time.LocalDate;
import java.util.List;

@Component
public class ReservationRunner implements CommandLineRunner {

    @Autowired
    private WorkspaceService workspaceService;

    @Autowired
    private UserService userService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public void run(String... args) throws Exception{
        System.out.println("-----------------------FILTERY BY WORKSPACETYPE AND BUILDING CITY-------------------------");
        List<Workspace> queryResult = workspaceService.searchWorkspaces(WorkspaceType.OPENSPACE, "Marino umbro");
        queryResult.forEach(System.out::println);

        System.out.println("-------------------------FILTERY BY USER USERNAME-------------------------");
        User filteredUser = userService.searchUser("Cheyk");
        System.out.println(filteredUser);

        System.out.println("------------------------MAKE RESERVATION-------------------------------");
        Reservation newReservation = new Reservation(filteredUser, LocalDate.now().plusDays(1), queryResult.getFirst());
        reservationService.saveReservation(newReservation);
        System.out.println("Reservation made!");
    }
}
