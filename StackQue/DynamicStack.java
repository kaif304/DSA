package StackQue;

public class DynamicStack extends CustomStack{
    public DynamicStack(){
        super();
    }
    public DynamicStack(int size){
        super(size);
    }
    @Override
    public boolean push(int val){
        if(this.isFull()){
            // double the array size
            int[] temp = new int[data.length * 2];
            // copy all previous item to new array

            for(int i=0; i< data.length; i++){
                temp[i] = data[i];
            }
            data = temp;
        }
        return super.push(val);
    }
}
