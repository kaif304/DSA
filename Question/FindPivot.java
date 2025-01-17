package Question;

public class FindPivot {
    static int getSum(int s,int e){
        int sum = 0;
        for (int i = s; i <= e; i++) {
            sum += i;
        }
        return sum;
    }
    static int findPivot(int n){
        int mid = n / 2;
        int l = getSum(1,mid);
        int r = getSum(mid, n);

        while(mid >= 1 && mid <= n){
            if(n == 1){
                return 1;
            }
            if(l == r){
                return mid;
            }
            if(l < r){
                l = l + mid + 1;
                r = r - mid;
                mid += 1;
            }
            else{
                l = l - mid;
                r = r + mid - 1;
                mid -= 1;
            }
        }
        return -1;
//        double y = (n * n + n)/2;
//        int x = (int)Math.sqrt(y);
//        return x * x == y ? x : -1;

    }

    public static void main(String[] args) {
        System.out.println(findPivot(12));
    }
}
