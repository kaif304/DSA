package Contest;
// TLE

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Node {
    int source, destination, timestamp;
    Node next;
    public Node(int src, int dest, int time){
        this.source = src;
        this.destination = dest;
        this.timestamp = time;
    }
}
class Router {
    HashMap<String, Boolean> map;
    int limit;
    int size;
    Node head;
    Node tail;

    public Router(int memoryLimit) {
        this.limit = memoryLimit;
        map = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
//        Node node = head;
//        while(node != null){
//            if(node.source == source && node.destination == destination && node.timestamp == timestamp){
//                return false;
//            }
//            node = node.next;
//        }
        String identity = source + "" + destination + timestamp;
        if(map.containsKey(identity) && map.get(identity)) return false;

        map.put(identity, true);
        Node packet = new Node(source, destination, timestamp);

        if(size == 0){
            head = packet;
            tail = packet;
            size++;
        }
        else if(size == limit){
            tail.next = packet;
            tail = tail.next;
            head = head.next;
        }
        else {
            tail.next = packet;
            tail = tail.next;
            size++;
        }

        return true;
    }

    public int[] forwardPacket() {
        if(head == null) return new int[0];

        int[] packet = new int[3];

        packet[0] = head.source;
        packet[1] = head.destination;
        packet[2] = head.timestamp;

        String identity = head.source + "" + head.destination + head.timestamp;
        map.put(identity, false);

        if(tail == head) {
            head = head.next;
            tail = tail.next;
            size--;
        }
        else {
            head = head.next;
            size--;
        }

        return packet;
    }

    public int getCount(int destination, int startTime, int endTime) {
        int count = 0;
        Node node = head;
        while(node != null){
            if(node.destination == destination && node.timestamp >= startTime && node.timestamp <= endTime){
                count++;
            }
            node = node.next;
        }
        return count;
    }
}

public class ImplementRouter {
    public static void main(String[] args) {
        // Input 1
        Router router = new Router(3);
        System.out.println(router.addPacket(1,4,90));
        System.out.println(router.addPacket(2,5,90));
        System.out.println(router.addPacket(1,4,90));
        System.out.println(router.addPacket(3,5,95));
        System.out.println(router.addPacket(4,5,105));

        System.out.println(Arrays.toString(router.forwardPacket()));

        System.out.println(router.addPacket(5,2,110));

        // Input 2

//        Router router = new Router(2);
//        System.out.println(router.addPacket(7,4,90));
//
//        System.out.println(Arrays.toString(router.forwardPacket()));
//
//        System.out.println(Arrays.toString(router.forwardPacket()));

        // Input 3

//        Router router = new Router(3);
//
//        System.out.println(router.addPacket(5,3,1));
//
//        System.out.println(Arrays.toString(router.forwardPacket()));
//
//        System.out.println(router.addPacket(3,1,1));
    }
}
