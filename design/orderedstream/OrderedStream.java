package design.orderedstream;

import java.util.ArrayList;
import java.util.List;

class OrderedStream {
    String[] stream;
    int pointer;
    public OrderedStream(int n) {
        this.stream = new String[n+1];
        this.pointer = 1;
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey] = value;

        List<String> list = new ArrayList<>();
        int streamSize = stream.length;

        while(pointer < streamSize && stream[pointer] != null){
            list.add(stream[pointer]);
            pointer++;
        }

        return list;
    }
}

/*
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */