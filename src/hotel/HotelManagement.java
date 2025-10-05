package hotel;

import java.util.*;

public class HotelManagement {
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
        for (Room room : rooms) {
            if (room.isAvailable() && room.getRoomNumber() == roomNumber) {
                room.bookRoom();
                int reservationId = reservations.size() + 1;
                Reservation reservation = new Reservation(reservationId, customer, room, checkInDate, checkOutDate);
                reservations.add(reservation);
                System.out.println("Booking Successful! " + reservation);
                return;
            }
        }
        System.out.println("Room not available.");
    }

    public void cancelRoom(int reservationId) {
        Iterator<Reservation> iterator = reservations.iterator();
        while (iterator.hasNext()) {
            Reservation reservation = iterator.next();
            if (reservation.getReservationId() == reservationId) {
                reservation.getRoom().releaseRoom();
                iterator.remove();
                System.out.println("Reservation Cancelled: " + reservationId);
                return;
            }
        }
        System.out.println("Reservation not found.");
    }
}
