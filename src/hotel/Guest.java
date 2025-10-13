package hotel;

import java.util.Scanner;

public class Guest extends User {

    public Guest(String name) {
        super(name, "Guest");
    }

    @Override
    public void showMenu(HotelManagement hotel, Scanner sc, Customer customer) {
        int choice;
        do {
            System.out.println("\n===== Guest Menu =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    hotel.showAvailableRooms();
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter your contact number: ");
                    String contact = sc.nextLine();
                    Customer newCustomer = new Customer(name, contact);
                    System.out.print("Enter room number to book: ");
                    int roomNo = sc.nextInt();
                    hotel.bookRoom(roomNo, newCustomer); 
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