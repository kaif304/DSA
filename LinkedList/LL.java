package LinkedList;
// Linked List first code
class LL{
    private Node head;
    private Node tail;
    private int size;
    public LL(){
        this.size = 0;
    }
    private class Node {
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
        }
        public Node(int data, Node node){
            this.data = data;
            this.next = node;
        }
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size += 1;
    }
    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }
    public void insertAtInd(int val,int ind){
        if(ind > size){
            System.out.println("index out of bound");
            return;
        }
        if(ind == 0){
            insertFirst(val);
            return;
        }
        if(ind == size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < ind; i++) {
            temp = temp.next;
        }
        Node node = new Node(val,temp.next);
        temp.next = node;
        size++;
    }
    public int deleteFirst(){
        int val = head.data;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }
    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }
        Node secondLast = get(size-2);
        int val = tail.data;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }
    // Give the reference of the node at index
    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    public int delInd(int index){
        if(index == 0){
            return deleteFirst();
        }if(index == size-1){
            return deleteLast();
        }

        Node prev = get(index-1);
        int val = prev.next.data;
        prev.next = prev.next.next;

        return val;
    }

    public Node find(int value){
        Node node = head;
        while(node != null){
            if(node.data == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(17);

        list.insertLast(99);

        list.insertAtInd(100,0);
//        list.insertAtInd(100,10);

//        System.out.println(list.deleteFirst());

        list.deleteLast();

        list.delInd(0);

        list.display();
        System.out.println("List size : "+list.size);
    }
}