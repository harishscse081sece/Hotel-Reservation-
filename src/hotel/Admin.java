package hotel;

import java.util.Scanner;

public class Admin extends User {

    public Admin(String name) {
        super(name, "Admin");
    }

    @Override
    public void showMenu(HotelManagement hotel, Scanner sc, Customer customer) {
        int choice;
        do {
            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. Add Room");
            System.out.println("2. View All Rooms");
            System.out.println("3. Apply Dynamic Pricing");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter room number: ");
                    int roomNumber = sc.nextInt();
                    System.out.print("Enter room type: ");
                    String type = sc.next();
                    System.out.print("Enter base price: ");
                    double price = sc.nextDouble();
                    hotel.addRoom(new Room(roomNumber, type, price));
                    break;

                case 2:
                    hotel.showAllRooms();
                    break;

                case 3:
                    System.out.print("Enter season (Peak / Normal / Off): ");
                    String season = sc.next();
                    hotel.applyDynamicPricing(season);
                    break;

                case 4:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 4);
    }
}
