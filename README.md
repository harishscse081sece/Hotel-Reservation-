Hotel Reservation System :
 
Project Overview
 The Hotel Reservation System is a Java console-based application with SQL database integration.  
 It allows users to check room availability, book rooms, cancel reservations, and manage customer details efficiently.  
 This project follows Object-Oriented Programming (OOP) principles like Encapsulation, Abstraction, Inheritance, and Polymorphism for a     modular design.

Features
 Add, update, and manage customer details  
 Book and manage room reservations  
 Check real-time room availability  
 Cancel bookings easily  
 Calculate total cost for each reservation  
 Organized database storage using SQL  

Tech Stack
 Language:** Java (Console-based)
 Database:** MySQL / PostgreSQL (choose one)
 Paradigm:Object-Oriented Programming
 Tools: JDBC (Java Database Connectivity)


OOP Concepts Used
Encapsulation: Private fields with getters/setters for Customer, Room, Reservation classes  
Abstraction: Separate methods for booking, cancellation, and cost calculation hide internal logic  
Inheritance: Different room types (SingleRoom, DoubleRoom) inherit from Room class  
Polymorphism: Common interface for displaying room/reservation details  


 UML Diagram

classDiagram
    class Customer {
        - int customerId
        - String name
        - String phone
        - String email
        + Customer(int, String, String, String)
        + getName() String
    }

    class Room {
        - int roomNumber
        - String type
        - double price
        - boolean isAvailable
        + Room(int, String, double)
        + isAvailable() boolean
        + bookRoom() void
        + releaseRoom() void
        + getDetails() String
        + getRoomNumber() int
        + getPrice() double
    }

    class Reservation {
        - Customer customer
        - Room room
        - String checkInDate
        - String checkOutDate
        + Reservation(int, Customer, Room, String, String)
        + calculateCost() double
        + getReservationId() int
        + getRoom() Room
        + toString() String
    }

    class HotelManagement {
        - List~Room~ rooms
        - List~Reservation~ reservations
        + HotelManagement()
        + addRoom(Room) void
        + showAvailableRooms() void
        + bookRoom(Customer, int, String, String) void
        + cancelRoom(int) void
    }

    class HotelReservationSystem {
        + main(String[]) void
    }

    Reservation --> Customer : "has"
    Reservation --> Room : "reserves"
    HotelManagement --> Room : "manages *"
    HotelManagement --> Reservation : "manages *"
    HotelReservationSystem --> HotelManagement : "uses"

 



```sql
CREATE DATABASE hotel_reservation;
