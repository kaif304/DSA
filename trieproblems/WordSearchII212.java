package trieproblems;
// COMPLETED - Hard

import java.util.ArrayList;
import java.util.List;

public class WordSearchII212 {
    Trie trie;
    public WordSearchII212(){
        this.trie = new Trie();
    }
    public class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }
    class Trie {
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
            for(String word:words){
                insert(word);
            }
        }
    }
    public void dfs(char[][] board, int row, int col, Node curr, StringBuilder word, boolean[][] vis, List<String> result){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }

        int idx = board[row][col] - 'a';
        if(curr.children[idx] == null || vis[row][col]) return;

        curr = curr.children[idx];
        word.append(board[row][col]);
        vis[row][col] = true;

        if(curr.eow){
            result.add(word.toString());
            curr.eow = false; // to avoid duplicates
        }

        dfs(board, row, col+1, curr, word, vis, result);
        dfs(board, row, col-1, curr, word, vis, result);
        dfs(board, row+1, col, curr, word, vis, result);
        dfs(board, row-1, col, curr, word, vis, result);

        word.deleteCharAt(word.length()-1);
        vis[row][col] = false;
    }
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        List<String> result = new ArrayList<>();
        boolean[][] vis = new boolean[m][n];

        this.trie.insertWords(words);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board,i,j,trie.root,new StringBuilder(),vis,result);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};

        WordSearchII212 problem = new WordSearchII212();
        System.out.println(problem.findWords(board, words));
    }
}
