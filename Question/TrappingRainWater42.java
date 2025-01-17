package Question;

public class TrappingRainWater42 {
//    static int trapWater2(int[]height){
//
//    }
    static int trapWater(int[]height){
        int water = 0;
        int s = 0;
        int e = height.length-1;
        int lm = 0;
        int rm = 0;
        while(s < e){
            if(height[s] < height[e]){
                if(height[s] >= lm){
                    lm = height[s];
                } else{
                    water += lm - height[s];
                }
                s++;
            }else{
                if(height[e] >= rm){
                    rm = height[e];
                } else{
                    water += rm - height[e];
                }
                e--;
            }
        }
        return water;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapWater(height));
    }
}
