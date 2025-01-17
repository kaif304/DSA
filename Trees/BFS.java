package Trees;

import java.util.*;

public class BFS {
    class Node{
        int val;
        Node left;
        Node right;
        int height;
        public Node(int val){
            this.val = val;
        }
    }
    Node root;
    public int height(){
        return height(root);
    }
    private int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }
    public void insert(int val){
        root = insert(val, root);
    }
    private Node insert(int val, Node node){
        if(node == null){
            return new Node(val);
        }

        if(val < node.val){
            node.left = insert(val, node.left);
        }

        if(val > node.val){
            node.right = insert(val, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return rotate(node);
    }
    private Node rotate(Node node){
        int balanceFactor = height(node.left) - height(node.right);

        // left heavy
        if(balanceFactor > 1){
            // left left
            if(height(node.left.left) - height(node.left.right) > 0){
                return rightRotate(node);
            }
            // left right
            if(height(node.left.left) - height(node.left.right) < 0){
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        // right heavy
        if(balanceFactor < -1){
            // right right
            if(height(node.right.left) - height(node.right.right) < 0){
                return leftRotate(node);
            }
            // right left
            if(height(node.right.left) - height(node.right.right) > 0){
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }
    private Node rightRotate(Node node){
        Node leftChild = node.left;
        Node rightOfLeftChild = leftChild.right;

        leftChild.right = node;
        node.left = rightOfLeftChild;

        node.height = Math.max(height(node.left), height(node.right)+1);
        leftChild.height = Math.max(height(leftChild.left), height(leftChild.right)+1);

        return leftChild;
    }
    private Node leftRotate(Node node){
        Node rightChild = node.right;
        Node leftOfRightChild = rightChild.left;

        rightChild.left = node;
        node.right = leftOfRightChild;

        rightChild.height = Math.max(height(rightChild.left), height(rightChild.right)+1);
        node.height = Math.max(height(node.left), height(node.right)+1);

        return rightChild;
    }
    public void print(){
        print(root, "Root node --> ");
    }
    private void print(Node node, String details){
        if(node == null){
            return;
        }
        System.out.println(details + node.val);

        print(node.left, "Left of "+node.val+" --> ");
        print(node.right, "Right of "+node.val+" --> ");
    }
    // BFS ( Breath First Search )
    public List<List<Integer>> printBFS(){
        return printBFS(root);
    }
    private List<List<Integer>> printBFS(Node node){
        List<List<Integer>> result = new ArrayList<>();
        if(node == null){
            return result;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = q.remove();
                currentLevel.add(currentNode.val);

                if(currentNode.left != null){
                    q.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    q.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
    // Return the next node of key node/successor node 
    public Node nextNode(int key){
        return nextNode(root, key);
    }
    private Node nextNode(Node node,int key){
        if(node == null){
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            Node currentNode = q.poll();

            if(currentNode.left != null){
                q.offer(currentNode.left);
            }
            if(currentNode.right != null){
                q.offer(currentNode.right);
            }

            if(currentNode.val == key){
                break;
            }
        }
        return q.peek();
    }
    // Traverse every level in ZigZag format 103
    public List<List<Integer>> levelZigZag(){
        return levelZigZag(root);
    }
    private List<List<Integer>> levelZigZag(Node root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<Node> queue = new LinkedList<>();
        queue.offerFirst(root);
        boolean reverse = false;

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                if(!reverse){
                    Node currentNode = queue.pollFirst();
                    currentLevel.add(currentNode.val);

                    if(currentNode.left != null){
                        queue.offerLast(currentNode.left);
                    }
                    if(currentNode.right != null){
                        queue.offerLast(currentNode.right);
                    }
                }
                else{
                    Node currentNode = queue.pollLast();
                    currentLevel.add(currentNode.val);

                    if(currentNode.right != null){
                        queue.offerFirst(currentNode.right);
                    }
                    if(currentNode.left != null){
                        queue.offerFirst(currentNode.left);
                    }
                }
            }
            reverse = !reverse;
            result.add(currentLevel);
        }
        return result;
    }
    // Bottom level order traversal 107
    public List<List<Integer>> bottomLevelTraverse(){
        return bottomLevelTraverse(root);
    }
    private List<List<Integer>> bottomLevelTraverse(Node root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(0, currentLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        BFS tree = new BFS();
        for (int i = 0; i < 10; i++) {
            tree.insert(i);
        }
//        System.out.println(tree.height());
//        tree.print();
//        System.out.println(tree.printBFS());
//        System.out.println(tree.nextNode(3).val);
//        System.out.println(tree.levelZigZag());
        System.out.println(tree.bottomLevelTraverse());
    }
}