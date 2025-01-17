package Question;

public class ContainerWithMostWater11 {
    static int area(int[] height){
        if(height.length == 1){
            return 0;
        }
        int area = 0;

        int left = 0;
        int right = height.length-1;
        while(left < right){
            if(height[left] <= height[right]){
                area = Math.max(height[left] * (right - left), area);
            }
            else{
                area = Math.max(height[right] * (right - left), area);
            }
            
            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }
        return area;
    }
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        int[] arr2 = {2,3,4,5,18,17,6};
        System.out.println(area(arr2));
    }
}
