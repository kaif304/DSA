package trie;

public class LongestWordWithAllPrefixes {
    MyTrie trie;
    public LongestWordWithAllPrefixes(){
        this.trie = new MyTrie();
    }
    static class MyTrie extends Trie{
        String result = "";
        public String longestWordWithAllPrefixes(){
            StringBuilder temp = new StringBuilder();

            dfs(root, temp);

            return result;
        }
        public void dfs(Node curr, StringBuilder temp){
            if(curr == null) return;

            for (int i = 0; i < 26; i++) {
                if(curr.children[i] != null && curr.children[i].eow){
                    temp.append( (char)(i+'a') );

                    if(temp.length() > result.length()) result = temp.toString();

                    dfs(curr.children[i], temp);

                    temp.deleteCharAt(temp.length()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        LongestWordWithAllPrefixes problem = new LongestWordWithAllPrefixes();

        String[] words = {"a","banana","app","appl","ap","apply","apple"};
        problem.trie.insertWords(words);

        System.out.println(problem.trie.longestWordWithAllPrefixes());
    }
}
