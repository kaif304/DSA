package Question;

public class BestTimeSellStock123 {
    static int lowest(int[] arr, int s){
        int l = s;
        for(int i = s; i < arr.length; i++){
            if(arr[i] < arr[l]){
                l = i;
            }
        }
        return l;
    }
    static int highest(int[] arr, int lowest){
        int h = lowest + 1;
        while(h < arr.length-1){
            if(arr[h+1] < arr[h]){
                break;
            }
            h++;
        }
        return h;
    }
    static int maxProfit(int[] prices) {
        int profit = 0;
        int lowest = lowest(prices, 0);
        if (lowest >= prices.length - 1) return 0;

        int highest = highest(prices, lowest);

        profit += prices[highest] - prices[lowest];

        lowest = lowest(prices, highest+1);
        highest = highest(prices, lowest);

        profit += prices[highest] - prices[lowest];

        return profit;
    }
    public static void main(String[] args) {
        int[] arr = {3,3,5,0,0,3,1,4};
        int[] arr2 = {7,6,4,3,1};
        System.out.println(maxProfit(arr2));
    }
}
