package design.mycalendar;

import java.util.ArrayList;
import java.util.List;

class MyCalendar {
    // use List<int[]> instead of Event
    List<Event> events;
    public MyCalendar() {
        // maximum 1000 durations will be stored in 1000 calls according to constraints
        this.events = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        // check if possible to set an event
        for (Event event : events) {
            if (!(endTime <= event.startTime || startTime >= event.endTime)) {
                return false;
            }
        }

        // set event
        events.add(new Event(startTime, endTime));

        return true;
    }
}

/*
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */
