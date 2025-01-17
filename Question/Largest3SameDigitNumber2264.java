package Question;

public class Largest3SameDigitNumber2264 {
    static String largestGoodInteger(String num){
        if(num.length() < 3){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length()-2; i++) {
            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i+1) == num.charAt(i+2)){
                if(!sb.isEmpty()){
                    if(sb.charAt(0) < num.charAt(i)){
                        sb.setLength(0);
                        sb.append(num.substring(i, i+3));
                    }
                }
                else{
                    sb.append(num.substring(i, i+3));
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "611129995";
        System.out.println('1' == '9');
        System.out.println(largestGoodInteger(s));
    }
}
