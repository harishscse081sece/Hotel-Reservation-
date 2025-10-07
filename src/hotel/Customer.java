package hotel;
import java.util.* ;

class Customer {
    private int customerId;
    private String name;
    private String phone;
    private String email;

    public Customer(int customerId, String name, String phone, String email) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }
}