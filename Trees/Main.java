package Trees;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
//         BinaryTree tree = new BinaryTree();
//         tree.populate(scanner);
//         tree.displayTree();

            BST tree = new BST();
            int[] numbers = {1,2,3,4,5,6,7,8,9,10};
            tree.populate(numbers);
//            System.out.println(tree.balanced());

//        int[] sortedArr = {1,2,3,4,5};
//        tree.populateSortedArr(sortedArr);
        tree.display();
        System.out.println(tree.balanced());
        System.out.println(tree.findHeight());

    }
}
