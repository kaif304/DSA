package Question;

public class RobotBoundedInCircle1041 {
    static boolean circleOrNot(String moves){
        int x = 0;
        int y = 0;
        int direction = 0;
        int i = 0;
        while(true) {
            if(x == 0 && y == 0){
                return true;
            }
            if(moves.charAt(i) == 'G'){

            }

            i++;
            if(i == moves.length()){
                i = 0;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(circleOrNot("GGLLGG"));
    }
}
