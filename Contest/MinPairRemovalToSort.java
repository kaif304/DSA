package Contest;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MinPairRemovalToSort {
    static boolean sorted(ArrayList<Integer> list){
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i) > list.get(i+1)) return false;
        }
        return true;
    }
    static int minimumPairRemoval(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int e : nums){
            list.add(e);
        }

        int ans = 0;

        while(list.size() > 1){

            int sum = Integer.MAX_VALUE;
            int pair = -1;

            for(int j=0; j<list.size()-1; j++){
                if(!sorted(list) && list.get(j) + list.get(j+1) < sum){
                    pair = j;
                    sum = list.get(j) + list.get(j+1);
                }
            }

            if(pair != -1){
                ArrayList<Integer> temp = new ArrayList<>();
                for(int i=0; i<list.size(); i++){
                    if(i == pair){
                        temp.add(sum);
                        i += 1;
                        ans++;
                    }
                    else temp.add(list.get(i));
                }
                list = temp;
            }
            else break;
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        System.out.println(minimumPairRemoval(arr));
    }
}
