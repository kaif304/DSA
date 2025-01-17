package Question;
// COMPLETED
public class SumDigitsAfterConvert1945 {
    static int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            int num = s.charAt(i) - 'a' + 1;
            sb.append(num);
        }

        int sum = 0;
        for(int i = 0; i < k; i++){

            for(int j = 0; j < sb.length(); j++){
                sum += (sb.charAt(j) - 48);
            }

            sb.setLength(0);
            sb.append(sum);
            if(i != k-1){
                sum = 0;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(getLucky("zbax", 2));
        System.out.println(getLucky("zbax", 2));
    }
}
