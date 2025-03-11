package SlidingWindow;

import java.util.HashMap;

public class SubStringsWithVowelKConsonant3306 {
    static long countOfSubstrings2(String word, int k){
        long ans = 0, n = word.length();

        int left = 0, right = 5 + k -1; // setting window size

        boolean a = false, e = false, i = false, o = false, u = false;
        int count = 0; // consonant count

        for (int j = left; j <= right; j++) {
            char ch = word.charAt(j);
            if(ch == 'a') a = true;
            else if(ch == 'e') e = true;
            else if(ch == 'i') i = true;
            else if(ch == 'o') o = true;
            else if(ch == 'u') u = true;
            else count++;
        }

        // slide the window
        while(right < n){
            if(a && e && i && o && u && count == k) ans++;

            char chLeft = word.charAt(left);
            if(chLeft == 'a') a = false;
            else if(chLeft == 'e') e = false;
            else if(chLeft == 'i') i = false;
            else if(chLeft == 'o') o = false;
            else if(chLeft == 'u') u = false;
            else count--;
            left++;

            right++;
            if(right == n) break;
            char chRight = word.charAt(right);
            if(chRight == 'a') a = true;
            else if(chRight == 'e') e = true;
            else if(chRight == 'i') i = true;
            else if(chRight == 'o') o = true;
            else if(chRight == 'u') u = true;
            else count++;
        }

        return ans;
    }

    static void insertChar(HashMap<Character, Integer> map, char ch){
        if(ch == 'a') map.put(ch, map.getOrDefault(ch, 0)+1);
        else if(ch == 'e') map.put(ch, map.getOrDefault(ch, 0)+1);
        else if(ch == 'i') map.put(ch, map.getOrDefault(ch, 0)+1);
        else if(ch == 'o') map.put(ch, map.getOrDefault(ch, 0)+1);
        else if(ch == 'u') map.put(ch, map.getOrDefault(ch, 0)+1);
        else map.put('c', map.getOrDefault('c', 0)+1);
    }
    static void removeChar(HashMap<Character, Integer> map, char ch){
        if(ch == 'a') map.put(ch, map.getOrDefault(ch, 0)-1);
        else if(ch == 'e') map.put(ch, map.getOrDefault(ch, 0)-1);
        else if(ch == 'i') map.put(ch, map.getOrDefault(ch, 0)-1);
        else if(ch == 'o') map.put(ch, map.getOrDefault(ch, 0)-1);
        else if(ch == 'u') map.put(ch, map.getOrDefault(ch, 0)-1);
        else map.put('c', map.getOrDefault('c', 0)-1);
    }

    static long countOfSubstrings(String word, int k){
        long ans = 0, n = word.length();
        System.out.println(word);

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);
        map.put('c', 0); // c for consonant
        int left = 0, right = 0;
        insertChar(map, word.charAt(left));
        insertChar(map, word.charAt(right));

        // a e i o u

        while(right <= n){
            if(map.get('a') > 0 && map.get('e') > 0 && map.get('i') > 0 && map.get('o') > 0 && map.get('u') > 0 && map.get('c') == k) ans++;

            if(left == right){
                right++;
                if(right < n) {
                    insertChar(map, word.charAt(right));
                }
            }
            else if(map.get('c') < k){
                right++;
                if(right < n) {
                    insertChar(map, word.charAt(right));
                }
            }
            else if(map.get('c') > k){
                removeChar(map, word.charAt(left));
                left++;
            }
            else if(right == n){
                removeChar(map, word.charAt(left));
                left++;
            }
            else {
                right++;
                if(right < n) {
                    insertChar(map, word.charAt(right));
                }
            }
            System.out.println("a="+map.get('a')+"  e="+map.get('e')+"  i="+map.get('i')+"  o="+map.get('o')+"  u="+map.get('u')+"  c="+map.get('c'));
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(countOfSubstrings("ieaouqqieaouqq", 1));
        System.out.println(countOfSubstrings("aeiou", 0));
        System.out.println(countOfSubstrings("iqeaouqi", 2));
    }
}
