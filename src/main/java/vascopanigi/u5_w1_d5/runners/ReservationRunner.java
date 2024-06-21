package vascopanigi.u5_w1_d5.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import vascopanigi.u5_w1_d5.entities.Reservation;
import vascopanigi.u5_w1_d5.entities.User;
import vascopanigi.u5_w1_d5.entities.Workspace;
import vascopanigi.u5_w1_d5.enums.WorkspaceType;
import vascopanigi.u5_w1_d5.repositories.ReservationRepository;
import vascopanigi.u5_w1_d5.services.BuildingService;
import vascopanigi.u5_w1_d5.services.ReservationService;
import vascopanigi.u5_w1_d5.services.UserService;
import vascopanigi.u5_w1_d5.services.WorkspaceService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Component
@Order(3)
public class ReservationRunner implements CommandLineRunner {

    @Autowired
    private WorkspaceService workspaceService;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private UserService userService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public void run(String... args) throws Exception{
//        System.out.println("-----------------------FILTERY BY WORKSPACETYPE AND BUILDING CITY-------------------------");
//        List<Workspace> queryResult = workspaceService.searchWorkspaces(WorkspaceType.OPENSPACE, "Marino umbro");
//        queryResult.forEach(System.out::println);
//
//        System.out.println("-------------------------FILTERY BY USER USERNAME-------------------------");
//        User filteredUser = userService.searchUser("Cheyk");
//        System.out.println(filteredUser);
//
//        System.out.println("------------------------MAKE RESERVATION-------------------------------");
//        Reservation newReservation = new Reservation(filteredUser, LocalDate.now().plusDays(1), queryResult.getFirst());
//        reservationService.saveReservation(newReservation);
//        System.out.println("Reservation made!");


        //---------------------------REFACTORED CODE------------------------------
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Hello and welcome to our reservation app!");
            System.out.println("Insert your username");
            System.out.println("Type 0 to exit.");

            String username = scanner.nextLine();

            if ("0".equals(username)) {
                break;
            }

            User user = userService.searchUser(username);

            if (user == null) {
                System.out.println("User not found. Would you like to:");
                System.out.println("1. Try again");
                System.out.println("2. Register a new user");

                int userChoice = Integer.parseInt(scanner.nextLine());

                if (userChoice == 1) {
                    continue;
                } else if (userChoice == 2) {
                    System.out.println("Enter your full name:");
                    String fullName = scanner.nextLine();
                    System.out.println("Enter your email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter your username:");
                    String newUsername = scanner.nextLine();

                    user = new User(newUsername, fullName, email);
                    userService.saveUser(user);
                    System.out.println("User registered successfully! :D");
                } else {
                    System.out.println("Invalid choice. Please try again.");
                    continue;
                }
            }

            System.out.println("Enter the city you want to search for workspaces:");
            buildingService.getAllDistinctCities().forEach(System.out::println);
            String city = scanner.nextLine();

            System.out.println("Select the type of workspace:");
            System.out.println("1. OPENSPACE");
            System.out.println("2. PRIVATE");
            System.out.println("3. MEETING ROOM");

            int workspaceTypeChoice = Integer.parseInt(scanner.nextLine());

            WorkspaceType workspaceType;
            switch (workspaceTypeChoice) {
                case 1:
                    workspaceType = WorkspaceType.OPENSPACE;
                    break;
                case 2:
                    workspaceType = WorkspaceType.PRIVATE;
                    break;
                case 3:
                    workspaceType = WorkspaceType.MEETING_ROOM;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }
            List<Workspace> workspaces = workspaceService.searchWorkspaces(workspaceType, city);

            if (workspaces.isEmpty()) {
                System.out.println("No available workspaces found for your criteria.");
                continue;
            }
            System.out.println("Available workspaces:");
            for (int i = 0; i < workspaces.size(); i++) {
                System.out.println((i + 1) + ". " + workspaces.get(i).getWorkspaceType());
            }

            System.out.println("Select a workspace to book (number):");
            int workspaceChoice = Integer.parseInt(scanner.nextLine());

            if (workspaceChoice < 1 || workspaceChoice > workspaces.size()) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            Workspace chosenWorkspace = workspaces.get(workspaceChoice - 1);

            System.out.println("Enter the date for the reservation (YYYY-MM-DD):");
            String dateString = scanner.nextLine();

            LocalDate reservationDate;
            try {
                reservationDate = LocalDate.parse(dateString);
            } catch (Exception e) {
                System.out.println("Invalid date format. Please try again.");
                continue;
            }

            Reservation newReservation = new Reservation(user, reservationDate, chosenWorkspace);
            try {
                reservationService.saveReservation(newReservation);
                System.out.println("Reservation made successfully!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
