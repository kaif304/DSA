package LinkedList;

public class XORLinkedList {
    private Node head = null;
    public class  Node {
        int val;
        Node prev;
        Node next;
        public Node(int val){
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public void insert(int val){
        if(head == null){
            head = new Node(val);
            return;
        }
        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    public void printList(){
        Node node = head;
        while(node != null){
            System.out.print(node.val+"->");
            node = node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        XORLinkedList xorList = new XORLinkedList();
//        for (int i = 100; i >= 10; i-=10) {
//            xorList.insert(i);
//        }
        xorList.insert(10);
        xorList.insert(20);
        int first = xorList.head.hashCode();
        int second = xorList.head.next.hashCode();
        int xorPointer = first ^ second;

        System.out.println(xorPointer);

        int prev = 2;
        int curr = 4;
        int next = 6;

        int xcurr = prev ^ next;
        System.out.println(prev ^ next);

//        xorList.printList();
    }
}
