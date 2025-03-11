package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BST2 {
    Node root = null;
    public class Node{
        int val;
        Node left=null;
        Node right=null;

        public Node(int v){
            this.val = v;
        }
        public Node (int val,Node left,Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public void populateBST(int[] values){
        root = populateBSTUtil(values,0,values.length-1);
    }
    private Node populateBSTUtil(int[] values,int s, int e){
        if(s > e){
            return null;
        }
        int mid = (s+e)/2;
        Node root = new Node(values[mid]);
        root.left = populateBSTUtil(values,s,mid-1);
        root.right = populateBSTUtil(values,mid+1,e);
        return root;
    }
    public void printTree(){
        printTreeUtil(root);
    }
    public void printTreeUtil(Node root){
        if(root == null){
            return;
        }
        printTreeUtil(root.left);
        System.out.print(root.val+" ");
        printTreeUtil(root.right);
    }

    public static void main(String[] args) {
        BST2 tree = new BST2();
        int[] nodes = {1,2,3,4,5,6,7,8};
        tree.populateBST(nodes);
        tree.printTree();
    }
}
