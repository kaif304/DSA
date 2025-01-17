package StackQue;

import java.util.*;

public class Inbuilt {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.isEmpty());

        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        System.out.println(q.peek());
        System.out.println(q.remove());

        Deque<Integer> d = new ArrayDeque<>();
        d.add(10);
        d.add(20);
        d.add(30);
        d.add(40);
    }
}
