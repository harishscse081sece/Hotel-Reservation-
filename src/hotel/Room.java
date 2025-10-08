package hotel;

public class Room {
    private int roomNumber;
    private String type;
    private double basePrice;
    private double currentPrice;
    private boolean occupied;

    public Room(int roomNumber, String type, double basePrice) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.basePrice = basePrice;
        this.currentPrice = basePrice;
        this.occupied = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void updateDynamicPrice(double occupancyRate, String season) {
        double multiplier = 1.0;
        if (season.equalsIgnoreCase("Peak")) {
            multiplier = 1.3 + occupancyRate;
        } else if (season.equalsIgnoreCase("Off")) {
            multiplier = 0.8 - (occupancyRate / 2);
        }
        currentPrice = basePrice * multiplier;
    }

    public void showRoom() {
        System.out.printf("Room %d (%s) - ₹%.2f - %s\n", 
            roomNumber, type, currentPrice, (occupied ? "Booked" : "Available"));
    }
}
