package hotel;

class Guest extends User {
    public Guest(String username) {
        super(username, "Guest");
    }

    @Override
    public void showMenu(HotelManagement hotel, Scanner sc, Customer customer) {
        while (true) {
            System.out.println("\n--- Guest Menu ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    hotel.showAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter room number: ");
                    int roomNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter check-in date (YYYY-MM-DD): ");
                    String checkIn = sc.next();
                    System.out.print("Enter check-out date (YYYY-MM-DD): ");
                    String checkOut = sc.next();
                    hotel.bookRoom(customer, roomNumber, checkIn, checkOut);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}