package SmartTourMate;

public class Package {
    private final int code;
    private final String name;
    private final double price;

    public Package(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Package Code: %-4d | Name: %-30s | Price: $%.2f", code, name, price);
    }
}
