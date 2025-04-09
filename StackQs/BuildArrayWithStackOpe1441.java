package StackQs;

import java.util.ArrayList;
import java.util.List;

public class BuildArrayWithStackOpe1441 {
    static List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();

        int i = 1;
        for(int e : target){
            if(i < e){
                int steps = 0;
                while(i < e){
                    list.add("Push");
                    steps++;
                    i++;
                }
                while(steps > 0){
                    list.add("Pop");
                    steps--;
                }
            }
            list.add("Push");
            i++;
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,3};
        System.out.println(buildArray(arr, 3));
    }
}
