package trie;

public class Node {
    Node[] children;
    boolean eow; // end of word

    public Node(){
        children = new Node[26];
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}
