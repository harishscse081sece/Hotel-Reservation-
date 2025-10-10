package hotel;

import java.util.*;

public abstract class User {
    protected String name;
    protected String role;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public abstract void showMenu(HotelManagement hotel, Scanner sc, Customer customer);
}
