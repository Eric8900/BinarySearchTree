import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter in numbers on a single line with spaces \n Example: 1 2 3 4 5");
        String[] s = sc.nextLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        BinarySearchTree tree = new BinarySearchTree(nums);
        //System.out.print(tree.preOrder(tree.getRoot(), 0));
        BSTGraphicsFrame frame = new BSTGraphicsFrame("Binary Search Tree", tree);
    }
}
