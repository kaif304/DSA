package StringQuestions;
import java.util.HashMap;

// Efficiency issue
public class MaxDiffBetEvenOddFreqII3445 {
    static HashMap<String, Integer> set = new HashMap<>();
    static int ans = Integer.MIN_VALUE;

    static int findValues(String subs, int k){
        if(subs.length() < k){
            return Integer.MIN_VALUE;
        }

        if(set.containsKey(subs)){
            return set.get(subs);
        }

        int[] map = new int[10];

        for (int i = 0; i < subs.length(); i++) {
            int pos = subs.charAt(i) - '0';
            map[pos]++;
        }

        int a = Integer.MIN_VALUE; // maximum odd
        int b = Integer.MAX_VALUE; // minimum even

        for (int i = 0; i < 10; i++) {
            if (map[i] % 2 == 0 && map[i] != 0) {
                b = Math.min(b, map[i]);
            }

            if (map[i] % 2 == 1 && map[i] != 0) {
                a= Math.max(a, map[i]);
            }
        }

        if (a == Integer.MIN_VALUE || b == Integer.MAX_VALUE) {
            return Integer.MIN_VALUE;
        }

        return a - b;
    }

    static void helper(String s, int start, int k) {
        if (start == s.length()) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int end = start; end < s.length(); end++) {
            sb.append(s.charAt(end));

            String sub = sb.toString();
            int max = findValues(sub, k);
//            System.out.println(sub+" : "+max);

            ans = Math.max(ans, max);
            set.put(sub, max);
        }
        helper(s, start + 1, k);
    }

    static int maxDifference(String s, int k) {
        helper(s, 0,  k);
        return ans;
    }

    public static void main(String[] args) {
        long s = System.currentTimeMillis();
//        System.out.println(maxDifference("12233", 4));
//        System.out.println(maxDifference("31234210313231", 6));
        System.out.println(maxDifference("4441434124014100342204102323030044103033414200004441432220000342043114034111212331310000440224301330222311341124134141234200012243322044302300021234423221420023243310401032221340220133231213024142442001310002343030131223022403441200440334423221100140043034023131033040221334012220402001003241444130320111433401040404311213010300043043144033231412113131044344040441022311013330002403114234030311442021002101130234441110231402224", 6));

        long e = System.currentTimeMillis();
        System.out.println("Time Taken: "+(e-s)+"ms");
    }
}
