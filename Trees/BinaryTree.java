package Trees;
import java.util.Scanner;
class BinaryTree {
    private  static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }
    private Node root;
    public void populate(Scanner sc) {
        System.out.println("Enter the root Node: ");
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc, root);
    }
    private void populate(Scanner sc,Node node) {
        // for left node
        System.out.println("Do you want to enter left of "+node.val);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter left value of "+node.val+" : ");
            int val = sc.nextInt();
            node.left = new Node(val);
            populate(sc, node.left);
        }
        // for right node
        System.out.println("Do you want to enter right of "+node.val);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter right value of "+node.val+" : ");
            int val = sc.nextInt();
            node.right = new Node(val);
            populate(sc, node.right);
        }
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
}
