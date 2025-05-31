package trie;

import java.util.ArrayList;
import java.util.List;
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
    public void insertWord(String word){
        insert(word);
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
        return countNodesUtil(root);
    }
    public int countNodesUtil(Node root){
        if(root == null) return 0;
        int count = 0;

        for(int i = 0; i < root.children.length; i++){
            if(root.children[i] != null){
                count += countNodesUtil(root.children[i]);
            }
        }

        return count + 1;
    }
    public void insertSuffixes(String word){
        for (int i = 0; i < word.length(); i++) {
            insert(word.substring(i));
        }
    }
    public List<String> allUniqueSubstrings(){
        List<String> list = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        allUniqueSubstringsUtil(root, list, temp);

        return list;
    }
    public void allUniqueSubstringsUtil(Node curr, List<String> result, StringBuilder temp){
        if(curr == null) return;

        for(int i = 0; i < 26; i++){
            if(curr.children[i] != null){
                temp.append( (char)(i+'a') );
                result.add(temp.toString());

                allUniqueSubstringsUtil(curr.children[i], result, temp);

                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
}
