package SmartTourMate;

public class Booking {
    private final Package bookedPackage;
    private String startDate;
    private String endDate;

    public Booking(Package bookedPackage) {
        this.bookedPackage = bookedPackage;
        this.startDate = "Not set";
        this.endDate = "Not set";
    }

    public void setTourDates(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return String.format("Booking - Package: %-30s | Start Date: %-10s | End Date: %-10s", bookedPackage.getName(), startDate, endDate);
    }
}
