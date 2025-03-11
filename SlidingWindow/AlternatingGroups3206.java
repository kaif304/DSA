package SlidingWindow;

public class AlternatingGroups3206 {
    static int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int left = i-1;
            if(i == 0) left = n-1;
            int right = i+1;
            right = right % n;

            if(colors[i] != colors[left] && colors[i] != colors[right]){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1};
        int[] arr2 = {0,1,0,0,1};

        System.out.println(numberOfAlternatingGroups(arr));
        System.out.println(numberOfAlternatingGroups(arr2));
    }
}
