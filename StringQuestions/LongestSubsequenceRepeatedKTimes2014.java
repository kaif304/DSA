package StringQuestions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubsequenceRepeatedKTimes2014 {
    static void dfs(String p, String up, int i, Map<String, Integer> map){
        if(i >= up.length()){
            map.put(p, map.getOrDefault(p, 0)+1);
            return;
        }

        dfs(p + up.charAt(i), up, i+1, map);
        dfs(p, up, i+1, map);
    }
    static String longestSubsequenceRepeatedK(String s, int k) {
        Map<String, Integer> map = new HashMap<>();

        dfs("", s, 0, map);

        for(String key : map.keySet()){
            System.out.println(key+"="+map.get(key));
        }

        String ans = "";
        for(String key : map.keySet()){
            if(map.get(key) == k && key.length() > ans.length()){
                ans = key;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String s = "letsleetcode";
//        System.out.println(longestSubsequenceRepeatedK(s, 2));
        System.out.println(longestSubsequenceRepeatedK("bb", 2));
    }
}
