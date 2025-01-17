package RecursionQs;
// Rotated Binary Search
public class RBS {
    static int search(int[] arr, int s, int e, int target){
        if(s > e){
            return -1;
        }
        int m = s + (e-s)/2;
        if(arr[m] == target){
            return m;
        }
        if(arr[s] <= arr[m]){
            if(target >= arr[s] && target <= arr[m]){
                return search(arr, s, m-1, target);
            }
            else{
                return search(arr, m+1, e, target);
            }
        }
        if(target >= arr[m] && target <= arr[e]){
            return search(arr, m+1, e, target);
        }
        return search(arr, s, m-1, target);
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr,0, arr.length-1, 2));
    }
}
