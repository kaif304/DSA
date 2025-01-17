package StringQuestions;
// COMPLETED
public class LengthStringAfterOperations3223 {
    static int minimumLength(String s){
        if(s.length() < 3){
            return s.length();
        }

        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            int pos = s.charAt(i) - 'a';
            freq[pos] += 1;
        }

        int resultLen = 0;
        for(int i=0; i<freq.length; i++){
            if(freq[i] >= 3){
                if(freq[i] % 2 == 0){
                    freq[i] = 2;
                }
                else{
                    freq[i] = 1;
                }
            }
            resultLen += freq[i];
        }
        return resultLen;
    }
    public static void main(String[] args) {
        System.out.println(minimumLength("abaacbcbb"));
        System.out.println(minimumLength("lyqkwhyy"));
        System.out.println(minimumLength("ucvbutgkohgbcobqeyqwppbxqoynxeuuzouyvmydfhrprdbuzwqebwuiejoxsxdhbmuaiscalnteocghnlisxxawxgcjloevrdcj"));
    }
}
