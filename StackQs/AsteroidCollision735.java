package StackQs;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision735 {
    static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;

        while(i < asteroids.length){
            int val = asteroids[i];

            if(!stack.isEmpty()){
                int peek = stack.peek();

                if(val < 0 && peek > 0){
                    if(Math.abs(val) == peek){
                        stack.pop();
                        i++;
                    }
                    else if(Math.abs(val) > peek){
                        stack.pop();
                        stack.push(val);
                        i++;
                    }
                    else {
                        stack.pop();i++;
                    }
                }
                else if(val > 0 && peek < 0){
                    if(val == Math.abs(peek)){
                        stack.pop();
                        i++;
                    }
                    else if(val > Math.abs(peek)){
                        stack.pop();
                        stack.push(val);
                        i++;
                    }
                    else {
                        stack.pop();i++;
                    }
                }
                else{
                    stack.push(val);
                    i++;
                }
            }
            else {
                stack.push(val);
                i++;
            }
        }

        int[] ans = new int[stack.size()];

        for (int j = ans.length-1; j >= 0; j--) {
            ans[j] = stack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] asteroids = {5,10,-5};
        int[] asteroids2 = {8,-8};
        int[] asteroids3 = {10,2,-5};

        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
        System.out.println(Arrays.toString(asteroidCollision(asteroids2)));
        System.out.println(Arrays.toString(asteroidCollision(asteroids3)));
    }
}
