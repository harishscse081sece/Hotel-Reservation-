import.java.util.*;
// Customer class
class Customer {
    private int customerId;
    private String name;
    private String phone;
    private String email;

    public Customer(int customerId, String name, String phone, String email) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }
}
// Room Class 
class Room {
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
// Reservation Class
class Reservation {
    private int reservationId;
    private Customer customer;
    private Room room;
    private String checkInDate;
    private String checkOutDate;

    public Reservation(int reservationId, Customer customer, Room room, String checkInDate, String checkOutDate) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
        public double calculateCost() {
        return room.getPrice(); 
    }

    public int getReservationId() {
        return reservationId;
    }

    public Room getRoom() {
        return room;
    }

    public String toString() {
        return "Reservation ID: " + reservationId +
                ", Customer: " + customer.getName() +
                ", Room: " + room.getDetails() +
                ", Check-In: " + checkInDate +
                ", Check-Out: " + checkOutDate;
    }
}