import java.util.Scanner;

// This class is for Testing of Small Code & Debugging
public class Test{
    public static void main(String [] args){
        int age;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        age = sc.nextInt();
        sc.close();

        if(age >= 18) System.out.println("You can vote");
        else System.out.println("You cannot vote!");
    }
}