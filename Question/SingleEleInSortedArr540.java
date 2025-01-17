package Question;

public class SingleEleInSortedArr540 {
    static int setBit(int n){
        if(n == 0) return 0;
        int count = 1;
        while((n & 1) != 1){
            n = n >> 1;
            count++;
        }
        return count;
    }
    static int nthBit(int n, int k){
        return (n >> k-1) & 1;
    }
    static int singleNonDuplicate(int[] nums) {
        int single = 0;

        for(int e: nums){
            single ^= e;
        }

        return single;
    }
    public static void main(String[] args) {
        int[] arr = {1,4,2,1,3,3,4};
//        System.out.println(singleNonDuplicate(arr));

//        System.out.println(nthBit(4,3));
//        System.out.println(setBit(4));
    }
}
