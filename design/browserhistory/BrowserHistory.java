package design.browserhistory;

class BrowserHistory {
    Node head;
    Node current;
    public BrowserHistory(String homepage){
        this.head = new Node(homepage);
        current = head;
    }

    public void visit(String url) {
        if(current.next != null) {
            current.next.prev = null;
        }

        current.next = new Node(url, current);
        current = current.next;
    }

    public String back(int steps) {
        for (int i = 0; i < steps && current.prev != null; i++) {
            current = current.prev;
        }

        return current.url;
    }

    public String forward(int steps) {
        for (int i = 0; i < steps && current.next != null; i++) {
            current = current.next;
        }

        return current.url;
    }
}
