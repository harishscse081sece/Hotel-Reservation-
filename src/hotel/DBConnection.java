package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/hotel_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root"; 
    private static final String PASSWORD = "HARISH"; 

    private static Connection conn = null;


    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println(" Database Connected Successfully!");
            } catch (SQLException e) {
                System.out.println(" Database Connection Failed!");
                e.printStackTrace();
            }
        }
        return conn;
    }
    public static void main(String[] args) {
        getConnection();
    }
 }
