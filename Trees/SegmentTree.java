package Trees;

public class SegmentTree {
    private class Node{
        int data;
        int s;
        int e;
        Node left;
        Node right;
        public Node(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
    Node root;
    public SegmentTree(int[] arr){
        // construct a tree using this array
        this.root = constructTree(arr, 0, arr.length-1);
    }
    private Node constructTree(int[] arr, int s, int e){
        if(s == e){
            Node leaf = new Node(s, e);
            leaf.data = arr[s];
            return leaf;
        }
        int mid = s + (e-s)/2;

        Node node = new Node(s, e);
        node.left = this.constructTree(arr, s, mid);
        node.right = this.constructTree(arr, mid+1, e);

        node.data = node.left.data + node.right.data;

        return node;
    }
    public int query(int qs, int qe){
        return query(this.root, qs, qe);
    }
    private int query(Node node, int qs, int qe){
        if(node.s >= qs && node.e <= qe){
            // Node is completely lying inside query
            return node.data;
        }
        else if(node.s > qe || node.e < qs){
            // node is completely outside the query range
            return 0;
        }
        else{
            return this.query(node.left, qs, qe) + this.query(node.right, qs, qe);
        }
    }

    // Update
    public void update(int index, int value){
        this.root.data = update(this.root, index, value);
    }
    private int update(Node node, int i, int val){
        // i == index
        if(i >= node.s && i <= node.e){
            if(i == node.s && i == node.e){
                node.data = val;
                return node.data;
            }
            else{
                node.data = update(node.left, i, val) + update(node.right, i, val);
                return node.data;
            }
        }
        return node.data;
    }

    public void display(){
        display(this.root);
    }
    private void display(Node node){
        String str = "";
        if(node.left != null){
            str = str + "Interval ["+node.left.s+"-"+node.left.e+"] and Data = "+node.left.data+" => ";
        }
        else{
            str = str + "No left child";
        }

        str = str + "Interval ["+node.s+"-"+node.e+"] and Data = "+node.data+" <= ";

        if(node.right != null){
            str = str + "Interval ["+node.right.s+"-"+node.right.e+"] and Data = "+node.right.data;
        }
        else{
            str = str + "No right child";
        }
        System.out.println(str + '\n');
        if(node.left != null){
            display(node.left);
        }
        if(node.right != null){
            display(node.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,8,7,6,-2,-8,4,9};
        SegmentTree tree = new SegmentTree(arr);
//        tree.display();
        System.out.println(tree.query(1,6));
    }
}
