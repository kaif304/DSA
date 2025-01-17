package Trees;
import java.util.PrimitiveIterator;
import java.util.Scanner;
class BST {
    public class Node{
        private int val;
        private int height;
        private Node left;
        private Node right;
        public Node(int val){
            this.val = val;
        }
        public int getValue(){
            return val;
        }
    }
    private Node root;
    public int height(Node node){
        if(node == null){
            return -1;
        }
        else{
            return node.height;
        }
    }
    public boolean isEmpty(){
        return root == null;
    }

    // make the tree with sorted array but it should be a balanced tree
    public void populateSortedArr(int[] sortedArr){
        populateSortedArr(sortedArr, 0, sortedArr.length);
    }
    private void populateSortedArr(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (start + end)/2;
        insert(arr[mid]);

        populateSortedArr(arr,start, mid);
        populateSortedArr(arr,mid + 1, end);
    }

    public void populate(int[] numbers){
        for (int number : numbers) {
            this.insert(number);
        }
    }
    public void insert(int value){
        root = insert(value,root);
    }
    private Node insert(int val,Node node){
        if(node == null){
            node = new Node(val);
            return node;
        }
        if (val < node.val) {
            node.left = insert(val, node.left);
        }
        if (val > node.val) {
            node.right = insert(val, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right))+1 ;
        return node;
    }

    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }
    public void display(){
        display(root,"Root node ");
    }
    private void display(Node node,String details){
        if(node == null){
            return;
        }
        System.out.println(details+node.getValue());

        display(node.left, "Left of: "+node.val+" --> ");
        display(node.right, "Right of: "+node.val+" --> ");
    }



    public void displayTree(){
        displayTree(root,0);
    }
    private void displayTree(Node node, int level) {
        if (node == null) {
            return;
        }
        displayTree(node.right,level+1);
        if(level != 0){
            for (int i = 0; i < level-1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------>"+node.val);
        }
        else{
            System.out.println(node.val);
        }
        displayTree(node.left,level + 1);
    }

    public int findHeight(){
        return findHeight(root);
    }
    public int findHeight(Node node){
        if(node == null){
            return -1;
        }
        int left = findHeight(node.left);
        int right = findHeight(node.right);
        int nHeight = Math.max(left, right)+1;

        return nHeight;
    }
}

