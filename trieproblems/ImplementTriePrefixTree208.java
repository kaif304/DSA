package trieproblems;
// COMPLETED

public class ImplementTriePrefixTree208 {
    Trie trie;
    public ImplementTriePrefixTree208(){
        this.trie = new Trie();
    }
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }
    static class Trie {
        Node root;
        public Trie() {
            this.root = new Node();
        }

        public void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {

                int idx = word.charAt(i) - 'a';

                if(node.children[idx] == null) {
                    node.children[idx] = new Node();
                }
                node = node.children[idx];
            }
            node.eow = true;
        }

        public boolean search(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {

                int idx = word.charAt(i) - 'a';

                if(node.children[idx] == null) {
                    return false;
                }
                node = node.children[idx];
            }

            return node.eow;
        }

        public boolean startsWith(String prefix) {
            Node node = root;
            for (int i = 0; i < prefix.length(); i++) {

                int idx = prefix.charAt(i) - 'a';

                if(node.children[idx] == null) {
                    return false;
                }
                node = node.children[idx];
            }

            return true;
        }
    }

    public static void main(String[] args) {
        ImplementTriePrefixTree208 problem = new ImplementTriePrefixTree208();

        problem.trie.insert("apple");
        System.out.println(problem.trie.search("apple"));

        System.out.println(problem.trie.search("app"));
        problem.trie.insert("app");
        System.out.println(problem.trie.search("app"));

        System.out.println(problem.trie.startsWith("appas"));
    }
}
