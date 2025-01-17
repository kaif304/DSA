package Question;
public class SumRootToLeafNumbers129 {
    class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }
    Node root;
    public void insert(int val){
        root = insert(val,root);
    }
    private void insert2(int val,Node node){
        if(node == null){
            root = new Node(val);
        }
        else if(node.left == null){
            node.left = new Node(val);
        }
        else{
            node.right = new Node(val);
        }
    }
    private Node insert(int val,Node node){
        if(node == null){
            return new Node(val);
        }
        if(val < node.val){
            node.left = insert(val,node.left);
        }
        if(val > node.val){
            node.right = insert(val,node.right);
        }
        return node;
    }
    int sum = 0;
    public int sumOfRootToLeaf(){
        sumOfRootToLeaf(root,0);
        return sum;
    }
    private void sumOfRootToLeaf(Node node,int path){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            sum += (path * 10) + node.val;
        }
        sumOfRootToLeaf(node.left,(path * 10) + node.val);
        sumOfRootToLeaf(node.right,(path * 10) + node.val);
    }
    public void printTree(){
        printTree(root,"Root node --> ");
    }
    private void printTree(Node node, String details){
        if(node == null){
            return;
        }
        System.out.println(details+node.val);
        printTree(node.left,"Left of "+node.val+" --> ");
        printTree(node.right,"Right of "+node.val+" --> ");
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers129 tree = new SumRootToLeafNumbers129();
        tree.insert2(4,tree.root);
        tree.insert2(9,tree.root);
        tree.insert2(0,tree.root);
        tree.insert2(5,tree.root.left);
        tree.insert2(1,tree.root.left);
        tree.printTree();
        System.out.println(tree.sumOfRootToLeaf());
    }
}
