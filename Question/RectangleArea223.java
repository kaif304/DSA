package Question;

public class RectangleArea223 {
    static int computeArea(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int rec1Area = Math.abs(x2 - x1) * Math.abs(y2 - y1);
        int rec2Area = Math.abs(x4 - x3) * Math.abs(y4 - y3);

        int overlapWidth = Math.max(0, Math.min(x2, x4) - Math.max(x1, x3));
        int overlapHeight = Math.max(0, Math.min(y2, y4) - Math.max(y1, y3));

        return (rec1Area + rec2Area) - (overlapWidth * overlapHeight);
    }
    public static void main(String[] args) {
        System.out.println(computeArea(-3,0,3,4,0,-1,9,2));
    }
}
