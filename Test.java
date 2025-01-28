import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

// This class is for Testing of Small Code & Debugging
public class Test{
    public static void main(String [] args){
        long start1 = System.currentTimeMillis();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            for (int i = 0; i < 10; i++) {
                writer.write("Hello");
            }
        }
        catch (FileAlreadyExistsException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done writing to file.");

        long end1 = System.currentTimeMillis();
        System.out.println("Time taken: "+(end1 - start1));
    }
}