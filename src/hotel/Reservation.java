package hotel;

public class Reservation {
    private Customer customer;
    private Room room;

    public Reservation(Customer customer, Room room) {
        this.customer = customer;
        this.room = room;
    }

    public void showReservation() {
        System.out.println(customer.getName() + " booked Room " + room.getRoomNumber());
    }
}
