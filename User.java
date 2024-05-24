package SmartTourMate;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String username;
    private final String password;
    private final List<Booking> bookings;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.bookings = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void bookPackage(Package pkg) {
        bookings.add(new Booking(pkg));
    }

    public void viewBookedPackages() {
        if (bookings.isEmpty()) {
            System.out.println("No packages booked.");
        } else {
            System.out.println("Booked Packages:");
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }

    public void setTourDates(String startDate, String endDate) {
        if (bookings.isEmpty()) {
            System.out.println("No packages booked. Please book a package first.");
            return;
        }
        Booking latestBooking = bookings.get(bookings.size() - 1);
        latestBooking.setTourDates(startDate, endDate);
    }
}
