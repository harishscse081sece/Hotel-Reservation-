package hotel;
import java.util.*;

class Admin extends User {
    public Admin(String username) {
        super(username, "Admin");
    }

    @Override
    public void showMenu(HotelManagement hotel, Scanner sc, Customer customer) {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Room");
            System.out.println("2. View Available Rooms");
            System.out.println("3. Book Room");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter room number: ");
                    int num = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter room type: ");
                    String type = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    hotel.addRoom(new Room(num, type, price));
                    System.out.println("Room added successfully!");
                    break;
                case 2:
                    hotel.showAvailableRooms();
                    break;
                case 3:
                    System.out.print("Enter room number: ");
                    int roomNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter check-in date (YYYY-MM-DD): ");
                    String checkIn = sc.next();
                    System.out.print("Enter check-out date (YYYY-MM-DD): ");
                    String checkOut = sc.next();
                    hotel.bookRoom(customer, roomNumber, checkIn, checkOut);
                    break;
                case 4:
                    System.out.print("Enter reservation ID: ");
                    int resId = sc.nextInt();
                    hotel.cancelRoom(resId);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}