package StackQs;
// COMPLETED
public class BackspaceStrCompare844 {
    static boolean backspaceCompare(String s, String t) {
        StringBuilder ss = new StringBuilder();
        StringBuilder tt = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!ss.isEmpty() && ch == '#'){
                ss.deleteCharAt(ss.length()-1);
            }
            else if(ch != '#'){
                ss.append(ch);
            }
        }

        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            if(!tt.isEmpty() && ch == '#'){
                tt.deleteCharAt(tt.length()-1);
            }
            else if(ch != '#'){
                tt.append(ch);
            }
        }

        System.out.println(ss);
        System.out.println(tt);

        return ss.toString().contentEquals(tt);
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("a##c", "#a#c"));
    }
}
