package hotel;

import java.util.Scanner;

public class HotelReservationSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HotelManagement hotel = new HotelManagement();
        Customer currentCustomer = new Customer("Guest", "0000000000");

        int choice;
        do {
            System.out.println("\n===== Hotel Reservation System =====");
            System.out.println("1. Admin");
            System.out.println("2. Manager");
            System.out.println("3. Guest");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            User user = null;
            switch (choice) {
                case 1:
                    user = new Admin("Admin");
                    break;
                case 2:
                    user = new Manager("Manager");
                    break;
                case 3:
                    user = new Guest("Guest");
                    break;
                case 4:
                    System.out.println("Thank you for using the system!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option! Try again.");
            }

            if (user != null)
                user.showMenu(hotel, sc, currentCustomer);

        } while (choice != 4);
    }
}
