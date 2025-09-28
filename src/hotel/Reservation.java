package hotel;

public class Reservation {
    private int reservationId;
    private Customer customer;
    private Room room;
    private String checkInDate;
    private String checkOutDate;

    public Reservation(int reservationId, Customer customer, Room room, String checkInDate, String checkOutDate) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public double calculateCost() {
        return room.getPrice();
    }

    public int getReservationId() {
        return reservationId;
    }

    public Room getRoom() {
        return room;
    }

    public String toString() {
        return "Reservation ID: " + reservationId +
                ", Customer: " + customer.getName() +
                ", Room: " + room.getDetails() +
                ", Check-In: " + checkInDate +
                ", Check-Out: " + checkOutDate;
    }
}
