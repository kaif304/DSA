package Question;

public class BestSightseeingPair1014 {
    static int maxScoreSightseeingPair(int[] values) {
        int max = Integer.MIN_VALUE;
        int m1 = 0;
        int m2 = 1;

        while (m2 < values.length) {
            max = Math.max(max, (values[m1] + values[m2] + m1 - m2));

            if (values[m2] >= values[m1]) {
                m1 = m2;
            }
            m2++;
        }

        return max;
    }
    public static void main(String[] args) {
        int[] arr = {8,1,5,2,6};
        int[] arr2 = {7,2,6,6,9,4,3};
        int ans = maxScoreSightseeingPair(arr2);
        System.out.println(ans);
    }
}
