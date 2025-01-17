package Question;
import java.util.LinkedList;
public class BaseballGame682 {
    static int calPoints(String[] operations) {
        LinkedList<Integer> list = new LinkedList<>();
        int sum = 0;

        for(String s : operations){
            if(s.matches("-?\\d+")){
                list.add(Integer.parseInt(s));
                sum += list.getLast();
            }
            else if(s.equals("+")){
                list.add( list.getLast() + list.get(list.size()-2));
                sum += list.getLast();
            }
            else if(s.equals("D")){
                list.add(list.getLast() * 2);
                sum += list.getLast();
            }
            else{
                sum -= list.getLast();
                list.removeLast();
            }
        }
        System.out.println(list);
        return sum;
    }
    public static void main(String[] args) {
        String[] op = {"5","-2","4","C","D","9","+","+"};
        String[] op2 = {"5","2","C","D","+"};
        System.out.println(calPoints(op2));
    }
}
