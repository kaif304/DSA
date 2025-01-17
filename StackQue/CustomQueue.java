package StackQue;

public class CustomQueue {
    private int[] data;
    int start = -1;
    int end = 0;
    private static final int defaultSize =10;
    public CustomQueue(){
        this.data = new int[defaultSize];
    }
    public CustomQueue(int size){
        this.data = new int[size];
    }
    public boolean isFull(){
        return end == data.length-1;
    }
    public boolean isEmpty(){
        return end == 0;
    }
    public boolean insert(int val){
        if(isFull()){
            return false;
        }
        data[end++] = val;
        return true;
    }

}
