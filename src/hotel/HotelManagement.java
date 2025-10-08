package hotel;

import java.util.*;

public class HotelManagement {
    List<Room> rooms = new ArrayList<>();
    List<Reservation> reservations = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
        System.out.println("Room added successfully!");
    }

    public void showAllRooms() {
        System.out.println("\n----- All Rooms -----");
        for (Room r : rooms) {
            r.showRoom();
        }
    }

    public void showAvailableRooms() {
        System.out.println("\n----- Available Rooms -----");
        for (Room r : rooms) {
            if (!r.isOccupied()) {
                r.showRoom();
            }
        }
    }

    public void showAllReservations() {
        System.out.println("\n----- All Reservations -----");
        for (Reservation res : reservations) {
            res.showReservation();
        }
    }

    public void bookRoom(int roomNumber, Customer customer) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber && !r.isOccupied()) {
                r.setOccupied(true);
                reservations.add(new Reservation(customer, r));
                System.out.println("Room " + roomNumber + " booked successfully!");
                return;
            }
        }
        System.out.println("Room not available or invalid number!");
    }

    public void applyDynamicPricing(String season) {
        int totalRooms = rooms.size();
        int booked = 0;

        for (Room r : rooms) {
            if (r.isOccupied()) booked++;
        }

        double occupancyRate = totalRooms == 0 ? 0 : (double) booked / totalRooms;

        for (Room r : rooms) {
            r.updateDynamicPrice(occupancyRate, season);
        }

        System.out.println("\nDynamic pricing updated for season: " + season);
    }
}
