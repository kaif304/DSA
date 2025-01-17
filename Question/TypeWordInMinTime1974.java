package Question;
// COMPLETED
// Minimum Time to Type Word Using Special Typewriter 1974
public class TypeWordInMinTime1974 {
    static int minTimeToType(String word) {
        int time = 0;
        int currPos = 1;

        for(int i = 0; i < word.length(); i++){
            int targetPos = word.charAt(i) - 'a' + 1;

            int forward = Math.abs(targetPos - currPos);
            int backward = 26 - forward;

            currPos = targetPos;

            time += Math.min(forward, backward);
        }

        return time + word.length();
    }
    public static void main(String[] args) {
        System.out.println(minTimeToType("abc"));
        System.out.println(minTimeToType("bza"));
    }
}
