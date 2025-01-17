package Question;

public class GrumpyBookstoreOwner1052 {
    static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int allSatisfied = 0;
        for (int i = 0; i < customers.length; i++) {
            if(grumpy[i] == 0){
                allSatisfied += customers[i];
            }
        }

        int max = 0;
        for (int i = 0; i <= customers.length-minutes; i++) {
            int sum = 0;
            int j = i;
            while(j < i+minutes){
                if(grumpy[j] != 0){
                    sum += customers[j];
                }
                j++;
            }
            max = Math.max(max, sum);
        }
        return allSatisfied + max;
    }

    static int maxSatisfied2(int[] customers, int[] grumpy, int minutes) {
        int allSatisfied = 0;
        int n = customers.length;

        // Calculate the number of already satisfied customers
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                allSatisfied += customers[i];
            }
        }

        // Calculate the additional satisfied customers if we use the secret technique
        int maxAdditionalSatisfied = 0;
        int currentAdditionalSatisfied = 0;

        // Initialize the first window of size `minutes`
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                currentAdditionalSatisfied += customers[i];
            }
        }
        maxAdditionalSatisfied = currentAdditionalSatisfied;

        // Slide the window across the rest of the array
        for (int i = minutes; i < n; i++) {
            // Add the new element entering the window
            if (grumpy[i] == 1) {
                currentAdditionalSatisfied += customers[i];
            }
            // Remove the element leaving the window
            if (grumpy[i - minutes] == 1) {
                currentAdditionalSatisfied -= customers[i - minutes];
            }
            // Update the maximum additional satisfied customers
            maxAdditionalSatisfied = Math.max(maxAdditionalSatisfied, currentAdditionalSatisfied);
        }

        return allSatisfied + maxAdditionalSatisfied;
    }
    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};

        System.out.println(maxSatisfied2(customers, grumpy, 3));
    }
}
