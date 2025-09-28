package hotel;

public class Room {
    private int roomNumber;
    private String type;
    private double price;
    private boolean isAvailable;

    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookRoom() {
        isAvailable = false;
    }

    public void releaseRoom() {
        isAvailable = true;
    }

    public String getDetails() {
        return "Room " + roomNumber + " (" + type + ") - ₹" + price + " Available: " + isAvailable;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getPrice() {
        return price;
    }
}
