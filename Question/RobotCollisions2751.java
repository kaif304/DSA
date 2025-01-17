package Question;
import java.util.*;

public class RobotCollisions2751 {
    static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < positions.length; i++) {
            map.put(positions[i], i);
        }

        Stack<Integer> st = new Stack<>();

        Arrays.sort(positions);

        int i = 0;
        while (i < positions.length) {
            if(!st.isEmpty()){
                if(directions.charAt(map.get(st.peek())) == 'R' && directions.charAt(map.get(positions[i])) == 'L'){
                    if( healths[map.get(st.peek())] == healths[map.get(positions[i])] ){
                        healths[map.get(st.pop())] = 0;
                        healths[map.get(positions[i])] = 0;
                        i++;
                    }
                    else if( healths[map.get(st.peek())] < healths[map.get(positions[i])] ){
                        healths[map.get(st.peek())] = 0;
                        st.pop();
                        healths[map.get(positions[i])] = healths[map.get(positions[i])] - 1;
                    }
                    else{
                        healths[map.get(positions[i])] = 0;
                        healths[map.get(st.peek())] = healths[map.get(st.peek())] - 1;
                        i++;
                    }
                }
                else{
                    st.push(positions[i]);
                    i++;
                }
            }
            else{
                st.push(positions[i]);
                i++;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int health : healths){
            if(health != 0){
                ans.add(health);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] positions = {3,5,2,6};
        int[] healths = {10,10,15,12};
        String directions = "RLRL";

        int[] positions1 = {5,4,3,2,1};
        int[] healths1 = {2,17,9,15,10};
        String directions1 = "RRRRR";

        int[] positions2 = {13,3};
        int[] healths2 = {17,2};
        String directions2 = "LR";
        System.out.println(survivedRobotsHealths2(positions, healths, directions));
    }
    // simpler with no benifit

    static List<Integer> survivedRobotsHealths2(int[] positions, int[] healths, String directions) {
        Integer[] indices = new Integer[positions.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt(i -> positions[i]));

        Stack<Integer> st = new Stack<>();

        int i = 0;
        while (i < positions.length) {
            if(!st.isEmpty()){
                if(directions.charAt(st.peek()) == 'R' && directions.charAt(indices[i]) == 'L'){
                    if( healths[st.peek()] == healths[indices[i]] ){
                        healths[st.pop()] = 0;
                        healths[indices[i]] = 0;
                        i++;
                    }
                    else if( healths[st.peek()] < healths[indices[i]] ){
                        healths[st.peek()] = 0;
                        st.pop();
                        healths[indices[i]] = healths[indices[i]] - 1;
                    }
                    else{
                        healths[indices[i]] = 0;
                        healths[st.peek()] = healths[st.peek()] - 1;
                        i++;
                    }
                }
                else{
                    st.push(indices[i]);
                    i++;
                }
            }
            else{
                st.push(indices[i]);
                i++;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int health : healths){
            if(health != 0){
                ans.add(health);
            }
        }
        return ans;
    }
}