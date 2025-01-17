package Question;
import java.util.Arrays;
import java.util.HashMap;
public class RelativeSortArr1122 {
    static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = arr1[0];
        for(int e:arr1){
            max = Math.max(e, max);
        }
        int[] count = new int[max+1];
        for (int ele: arr1) {
            count[ele]++;
        }

        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            while(count[i] > 0){
                arr1[index] = i;
                index++;
                count[i]--;
            }
        }
        for (int i = 0; i < count.length; i++) {
            while(count[i] > 0){
                arr1[index] = i;
                index++;
                count[i]--;
            }
        }
        return arr1;
    }
    // Solution 2 using hashmap
    static int[] relativeSortArray2(int[] arr1, int[] arr2){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int e:arr1) {
            if(map.containsKey(e)){
                map.put(e,map.get(e)+1);
            }else{
                map.put(e,1);
            }
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int e:arr2) {
            while(map.get(e) > 0){
                ans[index++] = e;
                map.put(e, map.get(e)-1);
            }
            map.remove(e);
        }
        int[] rem = new int[arr1.length - index];
        int in = 0;
        for (int e:arr1) {
            if(map.containsKey(e)){
                while(map.get(e) > 0){
                    rem[in++] = e;
                    map.put(e, map.get(e)-1);
                }
                map.remove(e);
            }
        }
        Arrays.sort(rem);
        for(int e:rem){
            ans[index++] = e;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(relativeSortArray2(arr1,arr2)));
    }
}
