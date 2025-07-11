package Contest;

import java.util.PriorityQueue;

public class CountPrimeGapBalancedSubarrays {
    static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
    static int[] primes(int[] arr, int l, int r){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = l; i <= r; i++) {
            if(isPrime(arr[i])){
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
            }
        }

        return new int[]{min, max};
    }
    static int primeSubarray(int[] arr, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> b-a);
        int count = 0, l = 0, r = 0;

        while(r < arr.length){
            int rightVal = arr[r];
            if(isPrime(rightVal)){
                min.add(rightVal);
                max.add(rightVal);
            }

            if(min.size() > 1 && max.size() > 1){
                int diff = max.peek() - min.peek();

                if(diff <= k) count++;

                while(diff > k){
                    int leftVal = arr[l];

                    if(isPrime(leftVal)){
                        if (!min.isEmpty()) min.remove(leftVal);
                        if (!max.isEmpty()) max.remove(leftVal);

                        if (!min.isEmpty() && !max.isEmpty()) diff = max.peek() - min.peek();
                    }

                    l++;
                }
            }
            r++;
        }

        return count;
    }
    static int primeSubarray2(int[] arr, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int primeNeed = 0, count = 0;

        int l = 0, r = 0;
        while(r < arr.length){
            int currRight = arr[r];
            if(isPrime(currRight)){
                min = Math.min(min, currRight);
                max = Math.max(max, currRight);
                primeNeed++;
            }

            int diff = max - min;

            while(diff >= k && primeNeed >= 2){
                if(diff <= k){
                    count++;
                }

                int currLeft = arr[l];
                if(isPrime(currLeft)){
                    primeNeed--;
                }
                l++;

                int[] primes = primes(arr, l, r);
                min = primes[0];
                max = primes[1];

                diff = max - min;

            }

            r++;
        }

        return count;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,5,7};
        System.out.println(primeSubarray(arr, 3));
    }
}
