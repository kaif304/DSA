package Question;

public class FindDupNumber287 {
    static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {3,3,3,3,3};
        int[] arr2 = {1,3,4,2,2};
        System.out.println(findDuplicate(arr2));
    }
}
