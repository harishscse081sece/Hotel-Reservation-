classDiagram
class User {
  <<abstract>>
  # String name
  # String role
  + User(String, String)
  + showMenu(HotelManagement, Scanner, Customer) void
}

class Admin {
  + Admin(String)
}

class Guest {
  + Guest(String)
}

class Manager {
  + Manager(String)
}

class Customer {
  - String name
  - String contact
  + Customer(String, String)
  + getName() String
  + getContact() String
}

class Room {
  - int roomNumber
  - String type
  - double basePrice
  - double currentPrice
  - boolean occupied
  + Room(int, String, double)
  + getRoomNumber() int
  + getType() String
  + getBasePrice() double
  + isOccupied() boolean
  + setOccupied(boolean) void
  + updateDynamicPrice(double, String) void
  + showRoom() void
}

class Reservation {
  - Customer customer
  - Room room
  + Reservation(Customer, Room)
  + showReservation() void
}

class DBConnection {
  - String URL
  - String USER
  - String PASSWORD
  - Connection conn
  + getConnection() Connection
  + main(String[]) void
}

class HotelManagement {
  - Connection conn
  + addRoom(Room) void
  + showAllRooms() void
  + showAvailableRooms() void
  + bookRoom(int, Customer) void
  + showAllReservations() void
  + applyDynamicPricing(String) void
}

class HotelReservationSystem {
  + main(String[]) void
}

User <|-- Admin
User <|-- Guest
User <|-- Manager

HotelManagement ..> DBConnection : uses
HotelManagement --> Room : manages
HotelManagement --> Customer : manages
HotelManagement --> Reservation : manages

HotelReservationSystem ..> HotelManagement : uses
HotelReservationSystem ..> Customer : uses
HotelReservationSystem ..> User : uses
Guest ..> Customer : creates
Manager ..> Reservation : manages
Admin ..> Room : manages