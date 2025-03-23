package LinkedList;
// COMPLETED
class Node {
    int val;
    Node next;
    public Node(int val){
        this.val = val;
    }
    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
}
class MyLinkedList {

    Node head;
    Node tail;
    int size;
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int get(int index) {
        if(index < 0 || index > size) return -1;
        Node node = head;
        for(int i=0; i < index; i++){
            node = node.next;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        if(head == null){
            head = new Node(val);
            tail = head;
            size++;
            return;
        }
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        if (size == 0) { // If empty list, set head and tail
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return; // Fix condition

        if (index == 0) {
            addAtHead(val);
            return;
        }
        if(index == size){
            addAtTail(val);
            return;
        }

        Node node = head;
        for (int i = 0; i < index - 1; i++) { // Stop at previous node
            node = node.next;
        }

        Node newNode = new Node(val);
        newNode.next = node.next;
        node.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return; // Fix condition

        if (index == 0) { // Remove head
            head = head.next;
            if (head == null) { // If list becomes empty, update tail
                tail = null;
            }
            size--;
            return;
        }

        Node node = head;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }

        if (node.next == tail) { // If deleting last node, update tail
            tail = node;
        }

        node.next = node.next.next;
        size--;
    }

    public void printList(){
        Node node = head;
        while(node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("null");
    }
}

public class DesignLinkedList707 {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3,0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        System.out.println(list.get(4));
        list.addAtHead(4);
        list.addAtIndex(5,0);
        list.addAtHead(6);

        list.printList();
        System.out.println(list.size);
        System.out.println(list.tail.val);
    }
}
