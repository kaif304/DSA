package LinkedList;

public class CircularLL {
    Node head;
    Node tail;
    private class Node {
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    public void insert(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }
    public void display(){
        Node node = head;

    }
    public static void main(String[] args) {

    }
}
