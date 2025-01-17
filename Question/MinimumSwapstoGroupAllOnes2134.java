package Question;

public class MinimumSwapstoGroupAllOnes2134 {
    static int minSwaps(int[] nums){
        int n = nums.length;
        int count1 = 0;

        for (int num : nums) {
            if (num == 1) {
                count1++;
            }
        }

        if (count1 == 0 || count1 == n) {
            return 0;
        }

        int currentWindowOnes = 0;
        for (int i = 0; i < count1; i++) {
            if (nums[i] == 1) {
                currentWindowOnes++;
            }
        }
        int maxWindowOnes = currentWindowOnes;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] == 1) {
                currentWindowOnes--;
            }
            if (nums[(i + count1 - 1) % n] == 1) {
                currentWindowOnes++;
            }

            maxWindowOnes = Math.max(maxWindowOnes, currentWindowOnes);
        }

        return count1 - maxWindowOnes;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,1,1,0,0};
        int[] arr1 = {0,1,1,1,0,0,1,1,0};
        int[] arr2 = {1,1,0,0,1};
        int[] arr4 = {1,1,1,0,0,1,0,1,1,0};

        System.out.println(minSwaps(arr));
        System.out.println(minSwaps(arr1));
        System.out.println(minSwaps(arr2));
        System.out.println(minSwaps(arr4));
    }
}
