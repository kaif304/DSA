package trieproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class WordBreak139 {
    class Node{
        Node[] children = new Node[26];
        boolean eow = false;
    }
    class Trie{
        Node root;
        public Trie(){
            this.root = new Node();
        }
        public void insert(String word){
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';

                if(node.children[idx] == null){
                    node.children[idx] = new Node();
                }
                node = node.children[idx];
            }
            node.eow = true;
        }
        public void insertWords(List<String> words){
            for(String word : words){
                insert(word);
            }
        }
        public boolean search(String word){
            Node node = root;

            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';

                if(node.children[idx] == null) return false;

                node = node.children[idx];
            }

            return node.eow;
        }
    }

    Trie trie;
    public WordBreak139(){
        this.trie = new Trie();
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        trie.insertWords(wordDict);

        return helper(s, 0);
    }
    HashMap<Integer, Boolean> memo = new HashMap<>();

    // index based - without creating new strings
    public boolean helper(String s, int start){
        if(start == s.length()) return true;
        if(memo.containsKey(start)) return memo.get(start);

        Node node = trie.root;

        for (int i = start; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';

            if(node.children[idx] == null) break;

            node = node.children[idx];

            if (node.eow && helper(s, i + 1)) {
                memo.put(start, true);
                return true;
            }
        }

        memo.put(start, false);
        return false;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("leet");
        words.add("code");
        String s = "leetcode";

        WordBreak139 obj = new WordBreak139();

        System.out.println(obj.wordBreak(s, words));
    }
}
