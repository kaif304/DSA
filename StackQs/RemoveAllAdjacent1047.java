package StackQs;

public class RemoveAllAdjacent1047 {
    static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int top = -1;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(top >= 0 && sb.charAt(top) == ch){
                sb.deleteCharAt(sb.length()-1);
                top--;
            }
            else{
                sb.append(ch);
                top++;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
}
