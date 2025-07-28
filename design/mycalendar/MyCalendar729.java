package design.mycalendar;
// COMPLETED

public class MyCalendar729 {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
//        System.out.println(myCalendar.book(10, 20));
//        System.out.println(myCalendar.book(15, 25));
//        System.out.println(myCalendar.book(20, 30));

        int[][] slots = {{47,50},{33,41},{39,45},{33,42},{25,32},{26,35},{19,25},{3,8},{8,13},{18,27}};

        for (int[] slot : slots) {
            System.out.println(myCalendar.book(slot[0], slot[1]));
        }
    }
}
