package trieproblems;
// COMPLETED

// GFG Problem
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Result {

    // Complete the 'contacts' function below.
    public static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        int prefixCount = 0;
    }
    public static class Trie {
        Node root;

        public Trie(){
            root = new Node();
        }

        public void add(String name){
            Node node = root;

            for(int i = 0; i < name.length(); i++){
                int idx = name.charAt(i) - 'a';

                if(node.children[idx] == null){
                    node.children[idx] = new Node();
                }

                node = node.children[idx];
                node.prefixCount++;
            }

            node.eow = true;
        }
        public int find(String subName){
            Node node = root;

            for(int i = 0; i < subName.length(); i++){
                int idx = subName.charAt(i) - 'a';

                if(node.children[idx] == null){
                    return 0;
                }

                node = node.children[idx];
            }

            return node.prefixCount;
        }

        public List<Integer> performQueries(List<List<String>> queries){
            List<Integer> list = new ArrayList<>();

            for(List<String> query : queries){
                String operation = query.get(0);
                String word = query.get(1);

                if(operation.equals("add")){
                    add(word);
                }
                else if (operation.equals("find")) {
                    list.add(find(word));
                }
            }

            return list;
        }
    }

    public static List<Integer> contacts(List<List<String>> queries) {
        Trie trie = new Trie();

        return trie.performQueries(queries);
    }

}

public class Contacts {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();

        for (int i = 0; i < queriesRows; i++) {
            queries.add(Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")));
        }

        System.out.println(queries);

        List<Integer> result = Result.contacts(queries);

        System.out.println(result);
    }
}

