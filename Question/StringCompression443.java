package Question;
import java.util.Arrays;
public class StringCompression443 {
    static int compress(char[] chars) {
        if(chars.length == 1){
            return 1;
        }
        StringBuilder p = new StringBuilder();
        helper(chars,0,p);
        for (int i = 0; i < p.length(); i++) {
            chars[i] = p.charAt(i);
        }
        return p.length();
    }
    static void helper(char[] arr, int i, StringBuilder p){
        if(i == arr.length){
            return;
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        int j = i;
        while(j+1  < arr.length && arr[j] == arr[j+1]){
            count++;
            j++;
        }
        sb.append(arr[j]);
        if (count > 1) {
            sb.append(count);
        }
        p.append(sb);
        helper(arr, j+1, p);
    }
    public static void main(String[] args) {
        char[] arr = {'a','a','b','b','c','c','c'};
        char[] arr2 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(arr));
        System.out.println(Arrays.toString(arr));
    }
}