package design.seatreservation;

import java.util.PriorityQueue;

class SeatManager {
    PriorityQueue<Integer> seats;
    int nextSeat;
    public SeatManager(int n) {
        this.seats = new PriorityQueue<>();
        this.nextSeat = 1;
    }

    public int reserve() {
        if(!seats.isEmpty()){
            return seats.poll();
        }

        int availableSeat = nextSeat;
        nextSeat++;

        return availableSeat;
    }

    public void unreserve(int seatNumber) {
        seats.add(seatNumber);
    }
}

/*
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
