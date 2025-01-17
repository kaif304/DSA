package StringQuestions;
// COMPLETED
import java.util.HashMap;

public class ConstructKPalinStrs1400 {
    static boolean oddCount(HashMap<Character, Integer> map, int k){
        int count = 0;
        for(char key : map.keySet()){
            if(map.get(key) % 2 == 1){
                count++;
            }
        }
        System.out.println(count);
        return !(count > k);
    }
    static boolean canConstruct2(String s, int k) {
        if(s.length() < k) return false;

        HashMap<Character, Integer> frequency = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0) + 1);
        }
        System.out.println(frequency);

        return oddCount(frequency, k);
    }

    // Optimized
    static boolean canConstruct(String s, int k) {
        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++){
            int pos = s.charAt(i) - 'a';
            arr[pos] += 1;
        }
        int count = 0;
        for (int j : arr) {
            if (j % 2 == 1) {
                count++;
            }
        }
        return !(count > k);
    }
    public static void main(String[] args) {
        System.out.println(canConstruct("annabelle", 2));
        System.out.println(canConstruct("cr", 7));
    }
}
