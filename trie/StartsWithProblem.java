package trie;

public class StartsWithProblem {
    static class MyTrie extends Trie {
        public boolean prefixSearch(String key){
            Node node = this.root;

            for (int i = 0; i < key.length(); i++) {
                int idx = key.charAt(i) - 'a';

                if(node.children[idx] == null) {
                    return false;
                }

                node = node.children[idx];
            }

            return true;
        }
    }
    MyTrie trie;
    public StartsWithProblem(String[] words){
        this.trie = new MyTrie();
        trie.insertWords(words);
    }

    public boolean startsWith(String key){

        return trie.prefixSearch(key);

    }

    public static void main(String[] args) {
        String[] words = {"apple", "app", "man", "mango", "woman"};
        String key = "app";

        StartsWithProblem problem = new StartsWithProblem(words);

        System.out.println(problem.startsWith(key));
    }
}
