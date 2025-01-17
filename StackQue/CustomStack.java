package StackQue;

public class CustomStack {
    protected int[] data;
    int top = -1;
    private static final int defaultSize = 10;
    public CustomStack() {
        this.data = new int[defaultSize];
    }
    public CustomStack(int size) {
        this.data = new int[size];
    }
    public boolean isFull(){
        return top == data.length-1;
    }
    public boolean isEmpy(){
        return top == -1;
    }
    public boolean push(int val){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }
        data[++top] = val;
        return true;
    }
    public int pop() throws Exception{
        if(isEmpy()){
            throw new Exception("Can't pop! Stack is empty");
        }
        return data[top--];
    }
    public int peek(){
        if(isEmpy()){
            System.out.println("Stack is empty");
        }
        return data[top];
    }
}
