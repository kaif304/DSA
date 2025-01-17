package Question;
import java.util.HashMap;
public class CountNumberOfNiceSubarrays1248 {
    static int numberOfSubarrays(int[] nums, int k){
        int count = 0;
        int oddCount = 0;
        int[] prefix = new int[nums.length+1];
        prefix[0] = 1;

        for(int num: nums){
            if(num % 2 == 1){
                oddCount++;
            }
            if(oddCount >= k){
                count += prefix[oddCount-k];
            }
            prefix[oddCount]++;
        }
        return count;
    }
    static int numberOfSubarrays2(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int right = 0;
        int oddCount = 0;
        int subarrayCount = 0;

        while (right < nums.length) {
            if (nums[right] % 2 == 1) {
                oddCount++;
                subarrayCount = 0;
            }

            while (oddCount == k) {
                if (nums[left] % 2 == 1) {
                    oddCount--;
                }
                subarrayCount++;
                left++;
            }

            count += subarrayCount;
            right++;
        }

        return count;
    }
    static int numberOfSubarrays3(int[] nums, int k) {
        int oddCount = 0;
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            if (num % 2 == 1) {
                oddCount++;
            }

            if (map.containsKey(oddCount - k)) {
                result += map.get(oddCount - k);
            }

            map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,1,1};
        int[] arr2 = {2,2,2,1,2,2,1,2,2,2};
        System.out.println(numberOfSubarrays(arr2, 2));
    }
}
