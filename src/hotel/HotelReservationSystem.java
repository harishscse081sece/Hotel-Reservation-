package hotel;

import java.util.Scanner;

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HotelManagement hotel = new HotelManagement();

        
        hotel.addRoom(new Room(101, "Single", 1500));
        hotel.addRoom(new Room(102, "Double", 2500));
        hotel.addRoom(new Room(103, "Suite", 4000));

        // Customer
        Customer customer = new Customer(1, "Harish", "1234567899", "harish.s2024cse@sece.ac.in");

        
        while (true) {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    hotel.showAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter room number: ");
                    int roomNumber = sc.nextInt();
                    System.out.print("Enter check-in date (YYYY-MM-DD): ");
                    String checkIn = sc.next();
                    System.out.print("Enter check-out date (YYYY-MM-DD): ");
                    String checkOut = sc.next();
                    hotel.bookRoom(customer, roomNumber, checkIn, checkOut);
                    break;
                case 3:
                    System.out.print("Enter reservation ID: ");
                    int reservationId = sc.nextInt();
                    hotel.cancelRoom(reservationId);
                    break;
                case 4:
                    System.out.println("Thank you for using Hotel Reservation System!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
