package RecursionQs;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        permutations("", "123");
        System.out.println(permutationsCount("", "123"));
        System.out.println(permutations2("","abc"));
    }

    public static void permutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i);
            permutations(first + ch + second, up.substring(1));
        }

    }
    public static int permutationsCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i);
            count = count + permutationsCount(first + ch + second, up.substring(1));
        }
        return count;
    }
    // Using ArrayList - every func call will create its own list to return
    static ArrayList<String> permutations2(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();

        for(int i=0; i <= p.length(); i++){
            String f = p.substring(0,i);
            String s = p.substring(i);
            ans.addAll(permutations2(f + up.charAt(0) + s, up.substring(1)));
        }
        return ans;
    }
}