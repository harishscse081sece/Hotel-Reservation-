package hotel;

import java.util.*;

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HotelManagement hotel = new HotelManagement();

        // Pre-added rooms
        hotel.addRoom(new Room(101, "Single", 1500));
        hotel.addRoom(new Room(102, "Double", 2500));
        hotel.addRoom(new Room(103, "Suite", 4000));

        System.out.println("Welcome to Hotel Reservation System");
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Select role (Guest / Manager / Admin): ");
        String role = sc.nextLine();

        User user;
        if (role.equalsIgnoreCase("Guest")) {
            user = new Guest(username);
        } else if (role.equalsIgnoreCase("Manager")) {
            user = new Manager(username);
        } else if (role.equalsIgnoreCase("Admin")) {
            user = new Admin(username);
        } else {
            System.out.println("Invalid role! Defaulting to Guest.");
            user = new Guest(username);
        }

        Customer customer = new Customer(1, username, "0000000000", username + "@example.com");
        user.showMenu(hotel, sc, customer);

        System.out.println("\nThank you for using the Hotel Reservation System!");
        sc.close();
    }
}