package hotel;

import java.util.*;

public class Manager extends User {

    public Manager(String name) {
        super(name, "Manager");
    }

    @Override
    public void showMenu(HotelManagement hotel, Scanner sc, Customer customer) {
        int choice;
        do {
            System.out.println("\n===== Manager Menu =====");
            System.out.println("1. View All Rooms");
            System.out.println("2. View Reservations");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    hotel.showAllRooms();
                    break;

                case 2:
                    hotel.showAllReservations();
                    break;

                case 3:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 3);
    }
}
