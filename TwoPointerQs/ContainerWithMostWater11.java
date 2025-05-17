package TwoPointerQs;
// COMPLETED

public class ContainerWithMostWater11 {
    static int maxArea(int[] height) {
        int area = 0;
        int l = 0, r = height.length-1;

        while(l < r){
            int currArea = (r-l) * Math.min(height[l], height[r]);
            area = Math.max(area, currArea);

            if(height[l] <= height[r]) {
                l++;
            }
            else {
                r--;
            }
        }

        return area;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(height));
    }
}
