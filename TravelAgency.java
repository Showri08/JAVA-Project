package SmartTourMate;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TravelAgency {
    private final List<User> users;
    private final List<Package> packages;
    private User loggedInUser;

    public TravelAgency() {
        users = new ArrayList<>();
        packages = new ArrayList<>();
        loggedInUser = null;

        // Adding some sample packages
        packages.add(new Package(1, "Luxury Beach Resort", 10000));
        packages.add(new Package(2, "Mountain Adventure", 8000));
        packages.add(new Package(3, "European City Tour", 12000));
        packages.add(new Package(4, "Safari Expedition", 15000));
        packages.add(new Package(5, "Asian Culinary Tour", 7000));
        packages.add(new Package(6, "Caribbean Cruise", 20000));
        packages.add(new Package(7, "Historical Egypt", 11000));
        packages.add(new Package(8, "Tropical Rainforest Adventure", 9000));
        packages.add(new Package(9, "Northern Lights Tour", 13000));
        packages.add(new Package(10, "Australian Outback Experience", 14000));
    }

    public void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        users.add(new User(username, password));
        System.out.println("Registration successful.");
    }

    public void login() {
        if (loggedInUser != null) {
            System.out.println("Already logged in.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = user;
                System.out.println("Login successful.");
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }

    public void logout() {
        if (loggedInUser == null) {
            System.out.println("No user is logged in.");
        } else {
            loggedInUser = null;
            System.out.println("Logout successful.");
        }
    }

    public void viewPackages() {
        System.out.println("\nAvailable Tour Packages:");
        if (packages.isEmpty()) {
            System.out.println("No packages available.");
        } else {
            for (Package pkg : packages) {
                System.out.println(pkg);
            }
        }
    }

    public void bookPackage() {
        if (loggedInUser == null) {
            System.out.println("You need to login first to book a package.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the package code to book: ");
        try {
            int packageCode = Integer.parseInt(scanner.nextLine());

            for (Package pkg : packages) {
                if (pkg.getCode() == packageCode) {
                    loggedInUser.bookPackage(pkg);
                    System.out.println("Package booked successfully.");
                    return;
                }
            }
            System.out.println("Package not found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a numeric package code.");
        }
    }

    public void viewBookedPackages() {
        if (loggedInUser == null) {
            System.out.println("You need to login first to view booked packages.");
            return;
        }
        loggedInUser.viewBookedPackages();
    }

    public void setTourDates() {
        if (loggedInUser == null) {
            System.out.println("You need to login first to set tour dates.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter tour start date (YYYY-MM-DD): ");
            String startDate = scanner.nextLine();
            System.out.print("Enter tour end date (YYYY-MM-DD): ");
            String endDate = scanner.nextLine();

            loggedInUser.setTourDates(startDate, endDate);
            System.out.println("Tour dates set successfully.");
        } catch (Exception e) {
            System.out.println("Invalid date format. Please try again.");
        }
    }
}
