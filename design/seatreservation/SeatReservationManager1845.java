package design.seatreservation;
// COMPLETED

public class SeatReservationManager1845 {
    public static void main(String[] args) {
        SeatManager seatManager = new SeatManager(5); // Initializes a SeatManager with 5 seats.

        System.out.println(seatManager.reserve());    // All seats are available, so return the lowest numbered seat, which is 1.
        System.out.println(seatManager.reserve());    // All seats are available, so return the lowest numbered seat, which is 1.

        seatManager.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].

        System.out.println(seatManager.reserve());    // All seats are available, so return the lowest numbered seat, which is 1.
        System.out.println(seatManager.reserve());    // All seats are available, so return the lowest numbered seat, which is 1.
        System.out.println(seatManager.reserve());    // All seats are available, so return the lowest numbered seat, which is 1.
        System.out.println(seatManager.reserve());    // All seats are available, so return the lowest numbered seat, which is 1.

        seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].
    }
}
