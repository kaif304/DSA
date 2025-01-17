package Question;

import java.util.Arrays;

public class MinNumberMovesToSeatEveryone2037 {
    static int minMovesToSeat(int[] seats, int[] students) {
        int moves = 0;

        Arrays.sort(seats);
        Arrays.sort(students);

        for (int i = 0; i < students.length; i++) {
            if(i != 0 && (students[i] == students[i-1] || seats[i] == seats[i-1])){
                continue;
            }
            else if(seats[i] < students[i]){
                while(students[i] != seats[i]){
                    students[i]--;
                    moves++;
                }
            }
            else{
                while(students[i] != seats[i]){
                    students[i]++;
                    moves++;
                }
            }
        }
        return moves;
    }
    public static void main(String[] args) {
        int[] seats = {3,1,5};
        int[] stu = {2,7,4};

        int[] seats2 = {2,2,6,6};
        int[] stu2 = {1,3,2,6};

        int[] seats3 = {4,1,5,9};
        int[] stu3 = {1,3,2,6};

        System.out.println(minMovesToSeat(seats3,stu3));
    }
}
