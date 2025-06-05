package trieproblems;
// COMPLETED

public class LongestCommonPrefix14 {
    Trie trie;
    public LongestCommonPrefix14(){
        this.trie = new Trie();
    }

    public static class Node{
        Node[] children = new Node[26];
        boolean eow = false;
    }
    public static class Trie{
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
        public void insertWords(String[] words){
            for(String word:words){
                insert(word);
            }
        }
        String longest = "";
        public String lCP(){ // longest Common Prefix
            dfs(root, new StringBuilder());
            return longest;
        }
        public void dfs(Node curr, StringBuilder sb) {
            if (curr == null) return;

            int childrenCount = 0;
            int next = -1;

            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    childrenCount++;
                    next = i;
                }
            }

            if (curr.eow || childrenCount != 1) {
                longest = sb.toString();
                return;
            }

            char ch = (char) (next + 'a');
            sb.append(ch);

            dfs(curr.children[next], sb);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public String longestCommonPrefix(String[] words) {
        trie.insertWords(words);
        return trie.lCP();
    }

    public static void main(String[] args) {
        String[] words = {"flower","flow","flight"};
        LongestCommonPrefix14 problem = new LongestCommonPrefix14();

        System.out.println(problem.longestCommonPrefix(words));
    }
}
