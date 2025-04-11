package StackQs;
// COMPLETED

public class RemoveStarsFromStr2390 {
    static String removeStars(String s) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!res.isEmpty() && s.charAt(i) == '*'){
                res.deleteCharAt(res.length()-1);
            }
            else res.append(s.charAt(i));
        }

        return res.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
    }
}
