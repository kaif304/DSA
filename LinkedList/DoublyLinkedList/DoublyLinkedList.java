package LinkedList.DoublyLinkedList;

public class DoublyLinkedList {
    Node head;
    Node tail;

    public void printList(){
        Node node = head;
        while(node != null){
            System.out.print(node.data+" -> ");
            node = node.next;
        }
        System.out.println("null");
    }
    public void addFirst(int val){
        if(head == null) {
            head = new Node(val);
            tail = head;
            return;
        }
        Node newNode = new Node(val);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    public void addLast(int val){
        if (head == null){
            addFirst(val);
            return;
        }

        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }

        Node newNode = new Node(val);

        curr.next = newNode;
        newNode.prev = curr;
        tail = newNode;
    }

    public void add(int val){
        addLast(val);
    }

    public void traverseForwardBackward(){
        Node node = head;

        while(node != null){
            System.out.print(node.data+" -> ");
            if(node.next == null) break;
            node = node.next;
        }
        System.out.println("null");

        while(node != null){
            System.out.print(node.data+" -> ");
            node = node.prev;
        }
        System.out.println("null");
    }

    public void addAtIndex(int val, int index){
        Node dummy = new Node(0, head, null);
        if(head != null) head.prev = dummy;

        Node curr = dummy;
        for (int i = 0; i < index && curr != null; i++) {
            curr = curr.next;
        }

        Node nextNode = curr.next;
        Node newNode = new Node(val, nextNode, curr);
        curr.next = newNode;

        if(nextNode != null){
            nextNode.prev = newNode;
        }

        if(newNode.next == null) tail = newNode;

        head = dummy.next;
        head.prev = null;
    }

    public void deleteFirst(){
        if(head != null){
            head = head.next;
            if(head != null) head.prev = null;
            else tail = null;
        }
    }

    public void deleteLast(){
        if(head != null){
            tail = tail.prev;
            if(tail != null) {
                tail.next.prev = null;
                tail.next = null;
            }
            else head = null;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList ddl = new DoublyLinkedList();

        ddl.addFirst(1);
        ddl.add(100);
        ddl.addLast(200);
        ddl.addAtIndex(300, 3);
        ddl.addAtIndex(0, 0);
        ddl.addAtIndex(150, 3);

        ddl.printList();
//        ddl.traverseForwardBackward();
    }
}
