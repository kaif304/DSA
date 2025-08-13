package Contest;
// COMPLETED

// A good Bit manipulation problem

import java.util.ArrayList;
import java.util.Arrays;

public class RangeProductQueriesOfPowers2438 {
    static ArrayList<Integer> generatePowers(int n){
        ArrayList<Integer> powers = new ArrayList<>();
        int power = 1;

        while(n > 0){
            if((n & 1) == 1){
                powers.add(power);
            }
            power *= 2;
            n >>= 1;
        }

        return powers;
    }
    static int[] productQueries(int n, int[][] queries) {
        int mod = 1000000007;
        int len = queries.length;
        int[] ans = new int[len];

        ArrayList<Integer> powers = generatePowers(n);

        for (int j = 0; j < len; j++) {
            int[] query = queries[j];
            long pro = 1;

            for(int k = query[0]; k <= query[1]; k++) {
                pro = (powers.get(k) * pro) % mod;
            }

            ans[j] = (int) pro;
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 15;
        int[][] queries = {{0,1},{2,2},{0,3}};
        System.out.println(Arrays.toString(productQueries(n, queries)));

        int n2 = 2;
        int[][] queries2 = {{0,0}};
        System.out.println(Arrays.toString(productQueries(n2, queries2)));
    }
}
