package Question;

public class HouseRobber198 {
    static int robHouse(int[] nums){
        if(nums.length < 3){
            return Math.max(nums[0],nums[1]);
        }
        int[] money = new int[nums.length];

        money[0] = nums[0];
        money[1] = nums[1];
        money[2] = nums[2] + nums[0];

        for(int i = 3; i< nums.length; i++){
            money[i] = Math.max(nums[i]+money[i-2], nums[i] + money[i-3]);
        }
        int maxMoney = Integer.MIN_VALUE;
        for(int e: money){
            maxMoney = Math.max(maxMoney, e);
        }
        return maxMoney;
    }
    public static void main(String[] args) {
        int[] arr = {2,7,9,3,1};
        System.out.println(robHouse(arr));
    }
}
