package StackQue;

public class Main {
    public static void main(String[] args) throws Exception {
        CustomStack st = new CustomStack(3);
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(30);
        System.out.println("Removed : "+st.pop());

        DynamicStack dst = new DynamicStack();
        dst.push(10);
        dst.push(20);
        dst.push(30);
        dst.push(30);
        dst.push(30);
        dst.push(30);
        dst.push(30);
        dst.push(30);
        dst.push(30);
        dst.push(30);
        dst.push(30);
        dst.push(30);
        System.out.println("Removed : "+st.pop());
    }
}
