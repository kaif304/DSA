package LinkedList.CircularLinkedList;

public class CircularLinkedList {
    Node head;
    Node tail;

    public void add(int val){
        if(head == null){
            head = new Node(val);
            tail = head;
            tail.next = head;
        }
        else {
            tail.next = new Node(val, head);
            tail = tail.next;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }
    public int size(){
        if(isEmpty()) return 0;

        Node node = head;
        int size = 0;

        do {
            size++;
            node = node.next;
        } while (node != head);

        return size;
    }

    public boolean contains(int val){
        if(head == null) return false;

        Node node = head;

        do{
            if(node.val == val) return true;
            node = node.next;
        }
        while(node != head);

        return false;
    }
    public Node findNode(int val){
        if(head == null) return null;

        Node node = head;

        do{
            if(node.val == val) return node;
            node = node.next;
        }
        while(node != head);

        return null;
    }
    public void clear(){
        head = null;
        tail = null;
    }

    public void printList(){
        if(head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node node = head;

        do{
            System.out.print(node.val+" -> ");
            node = node.next;
        }
        while(node != head);

        System.out.println("(back to head)");
    }
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.add(10);
        list.add(20);
        list.add(30);

        list.printList();
    }
}
