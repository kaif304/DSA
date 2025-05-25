package trie;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("hello");

        String[] words = {"the","a","thor","there","their","any"};
        trie.insertWords(words);

        System.out.println(trie.search("thor"));
        System.out.println(trie.search("an"));
        System.out.println(trie.search("their"));
        System.out.println(trie.search("these"));
    }
}
