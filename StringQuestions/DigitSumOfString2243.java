package StringQuestions;
// COMPLETED
public class DigitSumOfString2243 {
    static String digitSum(String s, int k) {
        while(s.length() > k){
            StringBuilder newSb = new StringBuilder();
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += s.charAt(i) - '0';
                if ((i + 1) % k == 0 || i == s.length() - 1) {
                    newSb.append(sum);
                    sum = 0;
                }
            }
            s = newSb.toString();
        }
        return s;
    }
    public static void main(String[] args) {
        System.out.println(digitSum("11111222223", 3));
    }
}
