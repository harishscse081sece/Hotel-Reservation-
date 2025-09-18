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
// Hotel Management Class 
class HotelManagement {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public HotelManagement() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
    }
    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void showAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        boolean found = false;
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room.getDetails());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No rooms available at the moment.");
        }
    }
     public void bookRoom(Customer customer, int roomNumber, String checkInDate, String checkOutDate) {
        for (Room room : rooms) {
            if (room.isAvailable() && room.getRoomNumber() == roomNumber) {
                room.bookRoom();
                int reservationId = reservations.size() + 1;
                Reservation reservation = new Reservation(reservationId, customer, room, checkInDate, checkOutDate);
                reservations.add(reservation);
                System.out.println("Booking Successful! " + reservation);
                return;
            }
        }
        System.out.println(" Room not available.");
    }
     public void cancelRoom(int reservationId) {
        Iterator<Reservation> iterator = reservations.iterator();
        while (iterator.hasNext()) {
            Reservation reservation = iterator.next();
            if (reservation.getReservationId() == reservationId) {
                reservation.getRoom().releaseRoom();
                iterator.remove();
                System.out.println("Reservation Cancelled: " + reservationId);
                return;
            }
        }
        System.out.println("Reservation not found.");
    }
}
// -------------------- Main Class --------------------
public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HotelManagement hotel = new HotelManagement();

        hotel.addRoom(new Room(101, "Single", 1500));
        hotel.addRoom(new Room(102, "Double", 2500));
        hotel.addRoom(new Room(103, "Suite", 4000));
        
        Customer customer = new Customer(1, "Harish", "1234567899", "harish.s2024cse@sece.ac.in");
