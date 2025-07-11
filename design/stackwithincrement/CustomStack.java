package design.stackwithincrement;

class CustomStack {
    // Internally using Doubly Linked List - name DLL
    DoublyLinkedList dll;
    public CustomStack(int maxSize) {
        dll = new DoublyLinkedList(maxSize);
    }

    public void push(int x) {
        dll.addLast(x);
    }

    public int pop() {
        return dll.deleteLast();
    }

    public void increment(int k, int val) {
        dll.incrementKValues(k, val);
    }
}
