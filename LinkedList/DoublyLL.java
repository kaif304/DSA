package LinkedList;

public class DoublyLL {
    Node head;
    private class Node {
        int val;
        Node next;
        Node prev;
        public Node(int val) {
            this.val = val;
        }
        public Node( int val, Node next,Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;
    }

    public Node find(int val){
        Node node = head;
        while(node != null){
            if(node.val == val){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public void insert(int after,int val){
        Node node = new Node(val);
        Node p = find(after);
        if(p == null){
            System.out.println("Node does not exist");
            return;
        }
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next != null){
            node.next.prev = node;
        }
    }
    public void display(){
        Node node = head;
//        Node last = null;
        while(node != null){
            System.out.print(node.val+" -> ");
//            last = node;
            node = node.next;
        }
        System.out.println("null");

        // Print in reverse
//        while(last != null){
//            System.out.print(last.val+" -> ");
//            last = last.prev;
//        }
    }
    public static void main(String[] args) {
        DoublyLL list = new DoublyLL();
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);

        list.insert(20,100);

        list.display();
    }
}
