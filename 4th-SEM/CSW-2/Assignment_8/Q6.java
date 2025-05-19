class SeatBookingSystem { 
    private int availableSeats; 
    public SeatBookingSystem(int totalSeats) { 
        this.availableSeats = totalSeats; 
    } 
    public void bookSeats(String customerName, int seatsRequested) { 
        System.out.println(customerName + " is trying to book " + seatsRequested 
+ " seat(s)."); 
        synchronized (this) { 
            if (availableSeats >= seatsRequested) { 
                availableSeats -= seatsRequested; 
                System.out.println(customerName + " successfully booked " + 
seatsRequested + 
                        " seat(s). Remaining seats: " + availableSeats); 
            } else { 
                System.out.println("Booking failed for " + customerName + 
                        ". Not enough seats available. Remaining seats: " + 
availableSeats); 
            } 
        } 
    } 
} 
public class Q6 { 
    public static void main(String[] args) { 
        SeatBookingSystem bookingSystem = new SeatBookingSystem(5); 
        Object[][] customers = { 
            {"Cust 1", 2}, 
            {"Cust 2", 1}, 
            {"Cust 3", 2}, 
            {"Cust 4", 1} 
        }; 
        for (Object[] customer : customers) { 
            String name = (String) customer[0]; 
            int seats = (int) customer[1]; 
            Thread thread = new Thread(() -> bookingSystem.bookSeats(name, 
seats), name); 
            thread.start(); 
        } 
    } 
} 
