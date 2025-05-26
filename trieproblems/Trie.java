package trieproblems;

public class Trie {
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
        for (String word : words) {
            insert(word);
        }
    }
}