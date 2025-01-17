package StringQuestions;
// COMPLETED
public class CapitalizeTitle2129 {
    static String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder(title);

        int i = 0;
        while(i < sb.length()){
            int j = i;
            while(j < sb.length() && sb.charAt(j) != ' '){
                j++;
            }

            StringBuilder word = new StringBuilder(sb.substring(i, j).toLowerCase());
            if(word.length() > 2){
                word.setCharAt(0, (char)((word.charAt(0)-96)+64));
                sb.replace(i, j, word.toString());
            }
            else{
                sb.replace(i, j, word.toString());
            }

            i = j+1;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(capitalizeTitle("capiTalIze Of tHe titLe"));
    }
}
