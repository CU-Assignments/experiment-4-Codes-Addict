class TicketBookingSystem {
    private static final int TOTAL_SEATS = 10;
    private final boolean[] seats = new boolean[TOTAL_SEATS];

    public synchronized boolean bookSeat(int seatNumber) {
        if (seatNumber < 0 || seatNumber >= TOTAL_SEATS || seats[seatNumber]) {
            return false;
        }
        seats[seatNumber] = true;
        return true;
    }
}

class BookingThread extends Thread {
    private final TicketBookingSystem bookingSystem;
    private final int seatNumber;

    BookingThread(TicketBookingSystem bookingSystem, int seatNumber, int priority) {
        this.bookingSystem = bookingSystem;
        this.seatNumber = seatNumber;
        setPriority(priority);
    }

    @Override
    public void run() {
        if (bookingSystem.bookSeat(seatNumber)) {
            System.out.println(Thread.currentThread().getName() + " booked seat " + seatNumber);
        } else {
            System.out.println(Thread.currentThread().getName() + " failed to book seat " + seatNumber);
        }
    }
}

public class Multithreading {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem();
        Thread vip1 = new BookingThread(bookingSystem, 2, Thread.MAX_PRIORITY);
        Thread vip2 = new BookingThread(bookingSystem, 3, Thread.MAX_PRIORITY);
        Thread user1 = new BookingThread(bookingSystem, 2, Thread.MIN_PRIORITY);
        Thread user2 = new BookingThread(bookingSystem, 3, Thread.MIN_PRIORITY);

        vip1.start();
        vip2.start();
        user1.start();
        user2.start();
    }
}