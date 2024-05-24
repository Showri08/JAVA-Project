package SmartTourMate;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TravelAgency travelAgency = new TravelAgency();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to the Travel Agency");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Tour Packages");
            System.out.println("4. Book Tour Package");
            System.out.println("5. View Booked Packages");
            System.out.println("6. Set Tour Dates");
            System.out.println("7. Logout");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> travelAgency.register();
                    case 2 -> travelAgency.login();
                    case 3 -> travelAgency.viewPackages();
                    case 4 -> travelAgency.bookPackage();
                    case 5 -> travelAgency.viewBookedPackages();
                    case 6 -> travelAgency.setTourDates();
                    case 7 -> travelAgency.logout();
                    case 8 -> {
                        running = false;
                        System.out.println("Thank you for using the Travel Agency.");
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
