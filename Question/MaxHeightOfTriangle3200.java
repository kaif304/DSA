package Question;

public class MaxHeightOfTriangle3200 {
    static int maxHeightOfTriangle(int red, int blue) {
        return Math.max(helper(red, blue), helper(blue, red));
    }
    static int helper(int red, int blue) {
        int height = 0;
        int i = 1;

        while (true) {
            if (i % 2 != 0) {
                if (red >= i) {
                    red -= i;
                } else {
                    break;
                }
            } else {
                if (blue >= i) {
                    blue -= i;
                } else {
                    break;
                }
            }
            height++;
            i++;
        }

        return height;
    }
    public static void main(String[] args) {
        System.out.println(maxHeightOfTriangle(2,4));
        System.out.println(maxHeightOfTriangle(1,1));
        System.out.println(maxHeightOfTriangle(10,1));
    }
}
