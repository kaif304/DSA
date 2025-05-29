package trie;

public class UniqueSubstrings {
    static class MyTrie extends Trie {
        Node root;
        public MyTrie(){
            root = new Node();
        }
    }
    public UniqueSubstrings(){
        trie = new MyTrie();
    }
    MyTrie trie;
    public void insertAllSuffix(String key){
        for (int i = 0; i < key.length(); i++) {
            String substring = key.substring(i);
            trie.insert(substring);
        }
    }
    public int countOfUniqueSubstrings(){
        return trie.countNodes();
    }

    public static void main(String[] args) {
        UniqueSubstrings problem = new UniqueSubstrings();
//        String key = "ababa"; // output - 10
        String key = "apple"; // output - 10

        problem.insertAllSuffix(key);
        System.out.println(problem.countOfUniqueSubstrings());
    }
}
