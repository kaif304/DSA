package Arrays;

public class MaxLengthValidSubsequenceI3201 {
    static int allOdds(int[] arr){
        int odds = 0;
        for(int num : arr){
            if(num % 2 == 1) odds++;
        }
        return odds;
    }
    static int allEvens(int[] arr){
        int evens = 0;
        for(int num : arr){
            if(num % 2 == 0) evens++;
        }
        return evens;
    }
    static int evenOdd(int[] arr){
        int evens = 0, odds = 0;
        boolean even = true;

        for(int num : arr){
            if(even){
                if(num % 2 == 0){
                    evens++;
                    even = false;
                }
            }
            else {
                if(num % 2 == 1){
                    odds++;
                    even = true;
                }
            }
        }

        return evens + odds;
    }
    static int oddEven(int[] arr){
        int odds = 0, evens = 0;
        boolean odd = true;

        for(int num : arr){
            if(odd){
                if(num % 2 == 1){
                    odds++;
                    odd = false;
                }
            }
            else {
                if(num % 2 == 0){
                    evens++;
                    odd = true;
                }
            }
        }

        return odds + evens;
    }
    static int maximumLength(int[] arr){
        int[] ans = new int[4];
        ans[0] = allEvens(arr);
        ans[1] = allOdds(arr);
        ans[2] = evenOdd(arr);
        ans[3] = oddEven(arr);

        int result = ans[0];
        for(int res : ans){
            result = Math.max(result, res);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,1,2,1,2};

        System.out.println(maximumLength(arr));
    }
}
