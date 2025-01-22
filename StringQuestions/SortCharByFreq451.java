package StringQuestions;
// COMPLETED
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class SortCharByFreq451 {
    static class Node{
        char ch;
        int count;
        public Node(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }
    static String frequencySort2(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));

        for(char ch : freq.keySet()){
            pq.add(new Node(ch, freq.get(ch)));
        }

        StringBuilder result = new StringBuilder();
        while(!pq.isEmpty()){
            Node node = pq.poll();
            for (int j = 0; j < node.count; j++) {
                result.append(node.ch);
            }
        }
        return result.toString();
    }

    static String frequencySort(String s) {
        // Step 1: Count the frequency of each character
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Create buckets for characters by frequency
        List<Character>[] buckets = new List[s.length() + 1];
        for (char ch : freq.keySet()) {
            int count = freq.get(ch);
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(ch);
        }

        // Step 3: Build the result string from buckets
        StringBuilder result = new StringBuilder();
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] != null) {
                for (char ch : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        result.append(ch);
                    }
                }
            }
        }

        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(frequencySort("Aabb"));
    }
}
