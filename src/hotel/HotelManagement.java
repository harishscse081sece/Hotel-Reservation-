package hotel;

import java.util.*;
 
class HotelManagement {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public HotelManagement() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void showAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        boolean found = false;
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room.getDetails());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No rooms available at the moment.");
        }
    }

    public void bookRoom(Customer customer, int roomNumber, String checkInDate, String checkOutDate) {
        Room roomToBook = getRoomByNumber(roomNumber);
        if (roomToBook != null && roomToBook.isAvailable()) {
            roomToBook.bookRoom();
            int reservationId = reservations.size() + 1;
            Reservation reservation = new Reservation(reservationId, customer, roomToBook, checkInDate, checkOutDate);
            reservations.add(reservation);
            System.out.println("Booking Successful! " + reservation);
        } else {
            System.out.println("Room " + roomNumber + " is not available or does not exist.");
        }
    }

    public void cancelRoom(int reservationId) {
        Reservation reservationToCancel = findReservation(reservationId);
        if (reservationToCancel != null) {
            reservationToCancel.getRoom().releaseRoom();
            reservations.remove(reservationToCancel);
            System.out.println("Reservation Cancelled: " + reservationId);
        } else {
            System.out.println("Reservation not found.");
        }
    }

    
     
     
    private Room getRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

  
    private Reservation findReservation(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId) {
                return reservation;
            }
        }
        return null;
    }
}