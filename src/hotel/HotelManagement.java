package hotel;

import java.util.*;
import java.sql.*;


public class HotelManagement {
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
            System.out.println("Room added successfully to DB");
        } catch (SQLException e) {
            System.out.println("Failed to add room to DB");
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
            System.out.println("Failed to retrieve rooms!");
            e.printStackTrace();
        }
    }

    public void showAvailableRooms() {
        try {
            String query = "SELECT * FROM rooms WHERE occupied = false";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("\n----- Available Rooms -----");
            while (rs.next()) {
                System.out.printf("Room %d (%s) - ₹%.2f\n",
                        rs.getInt("room_number"),
                        rs.getString("room_type"),
                        rs.getDouble("current_price"));
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve available rooms!");
            e.printStackTrace();
        }
    }

    public void bookRoom(int roomNo, Customer customer) {
        try {
            
            String checkQuery = "SELECT occupied FROM rooms WHERE room_number = ?";
            PreparedStatement checkPs = conn.prepareStatement(checkQuery);
            checkPs.setInt(1, roomNo);
            ResultSet checkRs = checkPs.executeQuery();

            if (checkRs.next() && !checkRs.getBoolean("occupied")) {
                
                String customerQuery = "INSERT INTO customers (name, contact) VALUES (?, ?)";
                PreparedStatement customerPs = conn.prepareStatement(customerQuery, Statement.RETURN_GENERATED_KEYS);
                customerPs.setString(1, customer.getName());
                customerPs.setString(2, customer.getContact());
                customerPs.executeUpdate();
                ResultSet generatedKeys = customerPs.getGeneratedKeys();
                int customerId = 0;
                if (generatedKeys.next()) {
                    customerId = generatedKeys.getInt(1);
                }

                String reservationQuery = "INSERT INTO reservations (room_number, customer_id) VALUES (?, ?)";
                PreparedStatement reservationPs = conn.prepareStatement(reservationQuery);
                reservationPs.setInt(1, roomNo);
                reservationPs.setInt(2, customerId);
                reservationPs.executeUpdate();

                String updateRoomQuery = "UPDATE rooms SET occupied = true WHERE room_number = ?";
                PreparedStatement updateRoomPs = conn.prepareStatement(updateRoomQuery);
                updateRoomPs.setInt(1, roomNo);
                updateRoomPs.executeUpdate();

                System.out.println("Room " + roomNo + " booked successfully!");
            } else {
                System.out.println("Room " + roomNo + " is not available or does not exist.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to book room!");
            e.printStackTrace();
        }
    }

    public void showAllReservations() {
        try {
            String query = "SELECT r.reservation_id, c.name, ro.room_number, ro.room_type " +
                           "FROM reservations r " +
                           "JOIN customers c ON r.customer_id = c.id " +
                           "JOIN rooms ro ON r.room_number = ro.room_number";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("\n----- All Reservations -----");
            while (rs.next()) {
                System.out.printf("Reservation ID %d: Customer %s booked Room %d (%s)\n",
                        rs.getInt("reservation_id"),
                        rs.getString("name"),
                        rs.getInt("room_number"),
                        rs.getString("room_type"));
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve reservations!");
            e.printStackTrace();
        }
    }

    public void applyDynamicPricing(String season) {
        System.out.println("Applying dynamic pricing for season: " + season);
    }
}