package hotel;

import java.sql.*;
import java.util.*;

public class HotelManagement {
    List<Room> rooms = new ArrayList<>();
    List<Reservation> reservations = new ArrayList<>();
    Connection conn = DBConnection.getConnection();

    public void addRoom(Room room) {
        try {
            String query = "INSERT INTO rooms (room_number, room_type, base_price, current_price, occupied) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, room.getRoomNumber());
            ps.setString(2, room.getType());
            ps.setDouble(3, room.getBasePrice());
            ps.setDouble(4, room.getBasePrice());
            ps.setBoolean(5, false);
            ps.executeUpdate();
            System.out.println("Room added successfully to DB!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showAllRooms() {
        try {
            String query = "SELECT * FROM rooms";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("\n----- All Rooms -----");
            while (rs.next()) {
                System.out.printf("Room %d (%s) - ₹%.2f - %s\n",
                        rs.getInt("room_number"),
                        rs.getString("room_type"),
                        rs.getDouble("current_price"),
                        rs.getBoolean("occupied") ? "Booked" : "Available");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void applyDynamicPricing(String season) {
        System.out.println("Applying dynamic pricing for season: " + season);
    }
    
    public void showAvailableRooms() {
        System.out.println("Displaying available rooms from the database...");
    }

    public void bookRoom(int roomNo, Customer customer) {
        System.out.println("Booking room " + roomNo + " for customer " + customer.getName() + "...");
    }

    public void showAllReservations() {
        System.out.println("Displaying all reservations...");
    }
}