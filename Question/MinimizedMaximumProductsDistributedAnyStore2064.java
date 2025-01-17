package Question;

public class MinimizedMaximumProductsDistributedAnyStore2064 {
    static int minMaxProducts(int n, int[] quantities) {
        int low = 1;
        int high = 0;

        // Find the maximum value in quantities for the upper bound of binary search
        for (int quantity : quantities) {
            high = Math.max(high, quantity);
        }

        int result = high;

        // Binary search to find the minimum possible x
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canDistribute(quantities, n, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    // Check if it's possible to distribute products with max x per store
    static boolean canDistribute(int[] quantities, int n, int x) {
        int storesNeeded = 0;

        for (int quantity : quantities) {
            // Calculate the number of stores needed for this quantity if each store gets at most x products
            storesNeeded += (quantity + x - 1) / x;
        }

        // Check if the total number of stores needed is within the limit
        return storesNeeded <= n;
    }

    public static void main(String[] args) {
        int n1 = 6;
        int[] quantities1 = {11, 6};
        System.out.println(minMaxProducts(n1, quantities1));
    }
}
