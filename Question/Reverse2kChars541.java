package Question;

public class Reverse2kChars541 {
    static void reverse(char[] arr, int start, int end){
        int s = start;
        int e = end;
        while(s < e){
            char temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
    static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for(int i=0; i <= arr.length; i+=(2*k)){
            if(i <= arr.length-1){
                reverse(arr, i, k);
            }
            else if(arr.length-i <= k){
                reverse(arr, i, arr.length-1);
            }
        }
        return new String(arr);
    }
    public static void main(String[] args) {
        String ans = reverseStr("abcd",2);
        System.out.println(ans);
    }
}
