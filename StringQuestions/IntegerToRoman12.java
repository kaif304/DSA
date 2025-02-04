package StringQuestions;
// Your implementation is pending
public class IntegerToRoman12 {
    /*
    I	1
    V	5
    X	10
    L	50
    C	100
    D	500
    M	1000
    */
    static String intToRoman2(int num){
        String[] digits = {"0","I","II","III","IV","V","VI","VII","VIII","IX","X"};

        while(num > 0){
            if(num >= 1000){ // M - 1000

            }
            else if(num >= 500){ // D - 500

            }
            else if(num >= 100){ // C - 100

            }
            else if(num >= 50){ // L - 50

            }
            else if(num > 10){ //

            }
            else{

            }
        }

        return "";
    }
    static String intToRoman(int num){
        System.out.println("Integer: " + num);
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder roman = new StringBuilder();
        for(int i=0;i<values.length;i++)
        {
            while(num >= values[i])
            {
                num = num - values[i];
                roman.append(romanLetters[i]);
            }
        }
        System.out.println("Corresponding Roman Numerals is: " + roman.toString());
        return roman.toString();
    }
    public static void main(String[] args) {
        intToRoman(36);
    }
}
