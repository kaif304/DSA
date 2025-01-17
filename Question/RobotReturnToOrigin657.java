package Question;

public class RobotReturnToOrigin657 {
    static boolean findOrigin(String move){
        int x = 0;
        int y = 0;
        for (int i = 0; i < move.length(); i++) {
            if(move.charAt(i) == 'U'){
                y++;
            }else if(move.charAt(i) == 'D'){
                y--;
            }else if(move.charAt(i) == 'L'){
                x--;
            }else{
                x++;
            }
        }
        return x == 0 && y == 0;
    }
    public static void main(String[] args) {
        System.out.println(findOrigin("LDRRLRUULR"));
    }
}
