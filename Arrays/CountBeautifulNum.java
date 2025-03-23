package Arrays;
// HARD
public class CountBeautifulNum {
    static int beautifulNumbers(int l, int r) {
        int count = 0;
        for(int i=l; i<=r; i++){
            if(equal(i)) {
                count++;
                System.out.println(i);
            }
            System.out.println();
        }
        return count;
    }
    static boolean equal(int n){
        System.out.println("for "+n);
        int pro = 1, sum = 0;
        while(n > 0){
            pro *= (n % 10);
            sum += (n % 10);
            System.out.println(pro+" % "+sum);
            n = n/10;
        }
        return pro % sum == 0;
    }
    public static void main(String[] args) {
        System.out.println(beautifulNumbers(10, 30));
    }
}
