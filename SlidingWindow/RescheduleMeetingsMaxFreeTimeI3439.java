package SlidingWindow;
// COMPLETED

import java.util.ArrayList;

public class RescheduleMeetingsMaxFreeTimeI3439 {
    static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int[] freeTime = extractFreeTime(eventTime, startTime, endTime);

        int left = 0, sum = 0, max = 0;

        for(int right = 0; right < freeTime.length; right++){
            sum += freeTime[right];

            while( (right-left+1) > k + 1){
                sum -= freeTime[left++];
            }

            max = Math.max(max, sum);
        }

        return max;
    }

    private static int[] extractFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int[] freeTime = new int[startTime.length+1];

        freeTime[0] = startTime[0];

        for (int i = 1; i < startTime.length; i++) {
            freeTime[i] = startTime[i] - endTime[i - 1];
        }

        freeTime[freeTime.length - 1] = eventTime - endTime[endTime.length - 1];

        return freeTime;
    }
    private static ArrayList<Integer> getIntegers(int eventTime, int[] startTime, int[] endTime) {
        ArrayList<Integer> freeTime = new ArrayList<>();

        for (int i = 0; i <= startTime.length; i++) {
            if(i == 0) {
                int freeStart = 0;
                int freeEnd = startTime[i];

                freeTime.add(freeEnd - freeStart);
            }
            else if(i == startTime.length){
                int freeStart = endTime[i-1];

                freeTime.add(eventTime - freeStart);
            }
            else {
                int freeStart = endTime[i-1];
                int freeEnd = startTime[i];

                freeTime.add(freeEnd - freeStart);
            }
        }
        return freeTime;
    }

    public static void main(String[] args) {
        int eventTime = 10, k = 1;
        int[] startTime = {0,2,9}, endTime = {1,4,10};
//        System.out.println(maxFreeTime(eventTime, k, startTime, endTime));

        int[] startTime2 = {0,17}, endTime2 = {14,19};
        int eventTime2 = 34, k2 = 2;
        System.out.println(maxFreeTime(eventTime2, k2, startTime2, endTime2));
    }
}
