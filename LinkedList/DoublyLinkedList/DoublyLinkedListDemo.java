package LinkedList.DoublyLinkedList;

public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = new Node(10);

        node1.next = node2;
        node2.prev = node1;

        System.out.println(node1.data);
        System.out.println(node1.next.data);
    }
}
