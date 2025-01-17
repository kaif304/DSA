package FileHandling;
import java.io.*;
//import java.io.FileReader;
//import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
//        try(InputStreamReader isr = new InputStreamReader(System.in)){
//            System.out.println("Enter some letters: ");
//            int letters = isr.read();
//            while(isr.ready()){
//                System.out.println((char)letters);
//                letters = isr.read();
//            }
//        }
//        catch (IOException e){
//            System.out.println(e.getMessage());
//        }
        try(FileReader fr = new FileReader("note.txt")){
            System.out.println("Enter some letters: ");
            int letters = fr.read();
            while(fr.ready()){
                System.out.println((char)letters);
                letters = fr.read();
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
