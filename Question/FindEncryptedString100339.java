package Question;

public class FindEncryptedString100339 {
    static String getEncryptedString(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int length = s.length();
        for (int i = 0; i < length; i++) {
            sb.setCharAt(i, s.charAt((i + k) % length));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getEncryptedString("dart",3));
    }
}
