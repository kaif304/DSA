package trie;

public class Trie {
    Node root;

    public Trie(){
        this.root = new Node();
    }

    public void insertWords(String[] words){
        Node node;

        for(String word : words){
            node = root;

            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';

                if(node.children[idx] == null){
                    node.children[idx] = new Node();
                }

                node = node.children[idx];
            }
            node.eow = true;
        }
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
    public boolean search(String word){
        Node node = root;

        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';

            if(node.children[idx] == null) {
                return false;
            }

            node = node.children[idx];
        }

        return node.eow;
    }
    public int countNodes(){
        return countNodesHelper(root);
    }
    public int countNodesHelper(Node root){
        if(root == null) return 0;
        int count = 0;

        for(int i = 0; i < root.children.length; i++){
            if(root.children[i] != null){
                count += countNodesHelper(root.children[i]);
            }
        }

        return count + 1;
    }
}
