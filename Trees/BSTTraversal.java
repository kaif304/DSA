package Trees;

class BSTTraversal {
    public class Node{
        int val;
        Node left;
        Node right;
        int height;
        public Node(int val){
            this.val = val;
        }
    }
    Node root;
    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public void populate(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }
    public void insert(int val){
        root = insert(root, val);
    }
    private Node insert(Node node, int val){
        if(node == null){
            node = new Node(val);
            return node;
        }
        if(val < node.val){
            node.left = insert(node.left,val);
        }
        if(val > node.val){
            node.right = insert(node.right,val);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    // Pre-Order Traversal
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.val+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // In-Order Traversal
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.val+" ");
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+" ");
    }

    public void display(){
        display(root,"Root node --> ");
    }
    private void display(Node node, String details){
        if(node == null){
            return;
        }
        System.out.println(details+node.val);

        display(node.left, "Left of: "+node.val+" --> ");
        display(node.right, "Right of: "+node.val+" --> ");
    }

    public static void main(String[] args) {
        BSTTraversal tree = new BSTTraversal();
        int[] arr = {5,2,4,6,3,8,1};
        tree.populate(arr);

        tree.preOrder();
        System.out.println();

        tree.inOrder();
        System.out.println();

        tree.postOrder();
        System.out.println();

        tree.display();
    }
}
