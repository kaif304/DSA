package RecursionQs;

public class FindKthCharacterInStringGameII3307 {
    static char kthCharacter(long k, int[] operations) {
        StringBuilder word = new StringBuilder("a");

        for(int i=0; i<operations.length; i++) {
            StringBuilder generated = new StringBuilder();

            if(operations[i] == 0){
                generated.append(word);
            }
            else{
                for (int j = 0; j < word.length(); j++) {
                    char next = (char) ('a' + (word.charAt(j) - 'a' + 1) % 26);
                    generated.append(next);
                }
            }

            word.append(generated);
        }

        return word.charAt((int)(k) - 1);
    }
    public static void main(String[] args) {
        int k = 5;
        int[] operations = {0,0,0};

        int k1 = 10;
        int[] operations1 = {0,1,0,1};

//        System.out.println(kthCharacter(k, operations));
        System.out.println(kthCharacter(k1, operations1));
    }
}
