// Hotel/Seat Reservation System: 3 Classes: Room/Seat (number, price, availability status), 
// Customer (details, assigned room), and Hotel (methods to book a room, check-out, and calculate the final bill).
package Problems;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class Room {
    private String roomNumber;
    private BigDecimal pricePerNight;
    private boolean isAvailable;

    public Room(String roomNumber, BigDecimal pricePerNight) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true; // Initially, the room is available
    }

    public String getRoomNumber() { return roomNumber; }
    public BigDecimal getPricePerNight() { return pricePerNight; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailability(boolean status) { this.isAvailable = status; }
}

class Customer {
    private String customerId;
    private String name;
    private Room assignedRoom;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.assignedRoom = null; // No room assigned initially
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public Room getAssignedRoom() { return assignedRoom; }

    public void assignRoom(Room room) { this.assignedRoom = room; }
    public void vacateRoom() { this.assignedRoom = null; }
}

class Hotel {
    private List<Room> rooms;
    private List<Customer> customers;

    public Hotel() {
        this.rooms = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addRoom(Room room) { rooms.add(room); }
    public void addCustomer(Customer customer) { customers.add(customer); }

    // Booking Logic
    public boolean bookRoom(String customerId, String roomNumber) {
        Customer customer = customers.stream().filter(c -> c.getCustomerId().equals(customerId)).findFirst().orElse(null);
        Room room = rooms.stream().filter(r -> r.getRoomNumber().equals(roomNumber)).findFirst().orElse(null);

        if (customer == null || room == null || !room.isAvailable()) {
            return false; // Booking failed
        }

        room.setAvailability(false);
        customer.assignRoom(room);
        return true; // Booking successful
    }

    // Check-out Logic
    public BigDecimal checkOut(String customerId) {
        Customer customer = customers.stream().filter(c -> c.getCustomerId().equals(customerId)).findFirst().orElse(null);
        if (customer == null || customer.getAssignedRoom() == null) {
            return BigDecimal.ZERO; // No charge if no room assigned
        }

        Room room = customer.getAssignedRoom();
        BigDecimal billAmount = room.getPricePerNight(); // Assuming 1 night stay for simplicity

        room.setAvailability(true);
        customer.vacateRoom();
        return billAmount;
    }
}

public class SeatReservationSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        // Adding rooms
        hotel.addRoom(new Room("101", new BigDecimal("1500.00")));
        hotel.addRoom(new Room("102", new BigDecimal("2000.00")));

        // Adding customers
        hotel.addCustomer(new Customer("C001", "Alice"));
        hotel.addCustomer(new Customer("C002", "Bob"));

        // Booking a room
        boolean bookingStatus = hotel.bookRoom("C001", "101");
        System.out.println("Booking Status for Alice: " + (bookingStatus ? "Success" : "Failed"));

        // Checking out
        BigDecimal bill = hotel.checkOut("C001");
        System.out.println("Bill for Alice: INR " + bill);
    }
}