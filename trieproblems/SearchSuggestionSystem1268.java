package trieproblems;
// COMPLETED

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class SearchSuggestionSystem1268 {
    Trie trie;

    public SearchSuggestionSystem1268() {
        this.trie = new Trie();
    }

    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }
    static class Trie {
        Node root;

        public Trie(){
            this.root = new Node();
        }

        public void insert(String product){
            Node node = root;

            for (int i = 0; i < product.length(); i++) {
                int idx = product.charAt(i) - 'a';

                if(node.children[idx] == null){
                    node.children[idx] = new Node();
                }

                node = node.children[idx];
            }

            node.eow = true;
        }
        public void insertProducts(String[] products) {
            for(String product:products){
                insert(product);
            }
        }
        public void dfs(Node curr, StringBuilder prefix, List<String> list){
            if(curr == null || list.size() >= 3) return;
            if(curr.eow) {
                list.add(prefix.toString());
            }

            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    prefix.append((char) (i + 'a'));
                    dfs(curr.children[i], prefix, list);
                    prefix.deleteCharAt(prefix.length() - 1);
                }
            }
        }
        public List<String> searchWords(String prefix) {
            Node node = root;
            for (int i = 0; i < prefix.length(); i++) {
                int idx = prefix.charAt(i) - 'a';
                if (node.children[idx] == null) return new ArrayList<>();
                node = node.children[idx];
            }

            List<String> suggestions = new ArrayList<>();
            dfs(node, new StringBuilder(prefix), suggestions);

            return suggestions;
        }
        public List<List<String>> getSuggestions(String searchWord) {
            List<List<String>> result = new ArrayList<>();

            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < searchWord.length(); i++) {
                prefix.append(searchWord.charAt(i));
                result.add(searchWords(prefix.toString()));
            }

            return result;
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // Important for lexicographical order
        trie = new Trie();
        trie.insertProducts(products);
        return trie.getSuggestions(searchWord);
    }
    public static void main(String[] args){
        SearchSuggestionSystem1268 problem = new SearchSuggestionSystem1268();

        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";

        List<List<String>> result = problem.suggestedProducts(products, searchWord);

        for(List<String> list : result){
            System.out.println(list);
        }
    }
}
