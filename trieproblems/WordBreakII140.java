package trieproblems;
// COMPLETED

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreakII140 {
    // Improved Version

//    No substring slicing in recursion — we pass start index and only create substring when word found.
//    Memoization on start index — no recomputation of same suffix.
//    Incremental Trie traversal — no need to repeatedly search from root for prefixes.
//    Efficient space/time for large inputs.

    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }

    static class Trie {
        Node root;
        public Trie(){
            root = new Node();
        }
        public void insert(String word){
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';

                if(node.children[idx] == null) node.children[idx] = new Node();

                node = node.children[idx];
            }
            node.eow = true;
        }
        public void insertWords(List<String> words){
            for(String word : words){
                insert(word);
            }
        }
    }

    Trie trie;
    HashMap<Integer, List<String>> memo;

    public List<String> dfs(String s, int start){
        if(memo.containsKey(start)) {
            return memo.get(start);
        }

        Node node = trie.root;
        List<String> result = new ArrayList<>();

        for (int i = start; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';

            if( node.children[idx] == null ){
                break; // word does not exist with character ch
            }

            node = node.children[idx];

            if (node.eow) {
                String word = s.substring(start, i + 1);
                if (i + 1 == s.length()) {
                    result.add(word);
                }
                else {
                    List<String> subSentences = dfs(s, i + 1);

                    for (String sub : subSentences) {
                        result.add(word + " " + sub);
                    }
                }
            }
        }

        memo.put(start, result);
        return result;
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        trie = new Trie();
        trie.insertWords(wordDict);
        memo = new HashMap<>();

        return dfs(s, 0);
    }

    public static void main(String[] args) {
        WordBreakII140 problemObj = new WordBreakII140();

        List<String> wordDict = new ArrayList<>(List.of(new String[]{"cat","cats","and","sand","dog"}));
        String s = "catsanddog";

        System.out.println(problemObj.wordBreak(s, wordDict));
    }

    // Working but inefficient version

//    static class Node{
//        Node[] children = new Node[26];
//        boolean eow = false;
//    }
//
//    static class Trie {
//        Node root;
//        public Trie(){
//            root = new Node();
//        }
//        public void insert(String word){
//            Node node = root;
//            for (int i = 0; i < word.length(); i++) {
//                int idx = word.charAt(i) - 'a';
//
//                if(node.children[idx] == null) node.children[idx] = new Node();
//
//                node = node.children[idx];
//            }
//            node.eow = true;
//        }
//        public void insertWords(List<String> words){
//            for(String word : words){
//                insert(word);
//            }
//        }
//        public boolean wordExist(String word){
//            Node node = root;
//            for (int i = 0; i < word.length(); i++) {
//                int idx = word.charAt(i) - 'a';
//
//                if(node.children[idx] == null) return false;
//
//                node = node.children[idx];
//            }
//            return node.eow;
//        }
//
//        public void dfs(String p, String up, List<String> sentences){
//            if(up.isEmpty()) {
//
//                if(!p.isEmpty()) sentences.add(p);
//                return;
//
//            }
//
//            for (int i = 0; i < up.length(); i++) {
//                String currentWord = up.substring(0, i+1);
//
//                if( wordExist(currentWord) ){
//
//                    if(p.isEmpty()){
//                        // do not include space before first word
//                        dfs(p + currentWord, up.substring(i+1), sentences);
//                    }
//                    else{
//                        // include space after a word
//                        dfs(p + " " + currentWord, up.substring(i+1), sentences);
//                    }
//
//                }
//            }
//        }
//
//        public List<String> generateSentences(String s, List<String> wordDict){
//            List<String> sentences = new ArrayList<>();
//
//            insertWords(wordDict);
//
//            dfs("", s, sentences);
//
//            return sentences;
//        }
//    }
//
//    Trie trie;
//
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        trie = new Trie();
//
//        return trie.generateSentences(s, wordDict);
//    }
}
