package design.stackwithincrement;
// COMPLETED

public class StackWithIncrementOperation1381 {
    public static void main(String[] args) {
        // leetcode exampe
        CustomStack stack = new CustomStack(3); // Stack is Empty []

        stack.push(1);                          // stack becomes [1]
        stack.push(2);                          // stack becomes [1, 2]

        System.out.println(stack.pop());                            // return 2 --> Return top of the stack 2, stack becomes [1]

        stack.push(2);                          // stack becomes [1, 2]
        stack.push(3);                          // stack becomes [1, 2, 3]
        stack.push(4);                          // stack still [1, 2, 3], Do not add another elements as size is 4

        stack.increment(5, 100);                // stack becomes [101, 102, 103]
        stack.increment(2, 100);                // stack becomes [201, 202, 103]

        System.out.println(stack.pop());                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        System.out.println(stack.pop());                            // return 202 --> Return top of the stack 202, stack becomes [201]
        System.out.println(stack.pop());                            // return 201 --> Return top of the stack 201, stack becomes []
        System.out.println(stack.pop());                            // return -1 --> Stack is empty return -1
    }
}
