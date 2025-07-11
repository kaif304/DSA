package design.stackwithincrement;

public class DoublyLinkedList {
    Node head;
    Node tail;
    int maxSize;
    int size;
    public DoublyLinkedList(int maxSize){
        this.head = null;
        this.tail = null;
        this.maxSize = maxSize;
        this.size = 0;
    }

    public void addFirst(int val){
        if(size == maxSize) return;

        Node newNode = new Node(val);

        if(head == null){
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int val) {
        if(size == maxSize) return;

        if(size == 0){
            addFirst(val);
            return;
        }

        Node newNode = new Node(val);

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;

        size++;
    }

    public int deleteLast(){
        if(size == 0) {
            return -1;
        }

        int val = tail.val;
        tail = tail.prev;

        if (tail != null) tail.next = null;
        else head = null;

        size--;

        return val;
    }

    public void incrementKValues(int k, int val) {
        if (size == 0) return;

        Node node = head;

        for (int i = 0; i < k && node != null; i++) {
            node.val += val;
            node = node.next;
        }
    }
}
