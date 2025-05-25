package trieproblems;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean eow; // end of word
}
class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void insertWord(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if(node.children[idx] == null){
                node.children[idx] = new TrieNode();
            }

            node = node.children[idx];
        }

        node.eow = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    public boolean dfs(TrieNode node, String word, int i){
        if(node == null) return false;


        if(i == word.length()) return node.eow;

        char ch = word.charAt(i);

        if(ch == '.'){
            for (int j = 0; j < 26; j++) {
                if(node.children[j] != null && dfs(node.children[j], word, i+1)){
                    return true;
                }
            }
            return false;
        }
        else {
            int idx = ch - 'a';
            return dfs(node.children[idx], word, i + 1);
        }
    }
}

public class SearchAndAddWord211 {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.insertWord("bad");
        wordDictionary.insertWord("dad");
        wordDictionary.insertWord("mad");

        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
}
