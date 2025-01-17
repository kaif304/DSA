package Question;

public class CountAndSay38 {
    static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        return helper(n, 1, "1");
    }
    static String helper(int n, int i, String p){
        if(i == n){
            return p;
        }
        StringBuilder sb = new StringBuilder();
        int j = 0;
        while(j < p.length()) {
            int count = 1;
            while (j + 1 < p.length() && p.charAt(j) == p.charAt(j + 1)) {
                count++;
                j++;
            }
            sb.append(count).append(p.charAt(j));
            j++;
        }
        return helper(n, i+1, sb.toString());
    }
    public static void main(String[] args) {
        System.out.println(countAndSay(30));
    }
}
