package BinarySrch;
// Find peak in the mountain array
public class FindPeak {
    static int findPeak(int[] arr){
        int s = 0;
        int e = arr.length-1;
        while(s < e){
            int mid = s + (e-s)/2;
            if(arr[mid] > arr[mid+1]){
                e = mid;
            }
            else{
                s = mid + 1;
            }
        }
        return s;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,5,3,2,1};
        System.out.println("Peak index : "+findPeak(arr));
    }
}
