package trie;

import java.util.HashSet;

public class WordBreakProblem {
    Trie trie;
    public WordBreakProblem(String[] words){
        this.trie = new Trie();
        trie.insertWords(words);
    }

    HashSet<String> memo = new HashSet<>();
    public boolean wordBreak(String key){
        if(key.isEmpty()) return true;
        if(memo.contains(key)) return false;

        for (int i = 1; i <= key.length(); i++) {
            String firstPart = key.substring(0, i);
            String secondPart = key.substring(i);

            if(trie.search(firstPart) && wordBreak(secondPart)){
                return true;
            }
        }
        memo.add(key);

        return false;
    }
    public static void main(String[] args) {
        String[] words = {"i", "like", "sam", "samsung", "mobile"};
        String key = "ilikesamsungmobile";

        String[] words2 = {
                "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "icecream",
                "man", "go", "mango", "and", "play", "player", "enjoy", "joy", "love", "the",
                "best", "world", "cup", "worldcup", "won", "match", "is", "great", "fun",
                "we", "are", "champion", "champions", "this", "our", "day", "night", "sun",
                "shine", "sunshine", "win", "big", "dream", "bigdream"
        };
        String key2 = "welovethebigdreamicecreamplayer";


        // words will be inserted into trie by constructor
        WordBreakProblem wbp = new WordBreakProblem(words);

        System.out.println(wbp.wordBreak(key));
    }
}
